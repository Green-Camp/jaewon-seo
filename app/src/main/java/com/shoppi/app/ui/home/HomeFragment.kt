package com.shoppi.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.shoppi.app.R
import com.shoppi.app.databinding.FragmentHomeBinding
import com.shoppi.app.home.module.GlideApp
import com.shoppi.app.ui.home.adapter.HomeBannerAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "binding is null" }
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setJsonData()
    }

    private fun setJsonData() {
        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")

        if (!homeJsonString.isNullOrEmpty()) {

            with(binding) {
                viewModel.title.observe(viewLifecycleOwner) { title ->
                    tvHomeTitleText.text = title.text
                    GlideApp.with(requireContext())
                        .load(title.iconUrl)
                        .into(ivHomeTitleLogo)
                }

                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    vpHomeBanner.adapter = HomeBannerAdapter().apply {
                        submitList(banners)
                    }
                }

                val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
                val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)

                val screenWidth = resources.displayMetrics.widthPixels
                val offset = screenWidth - pageWidth - pageMargin

                vpHomeBanner.offscreenPageLimit = 3
                vpHomeBanner.setPageTransformer { page, position ->
                    page.translationX = position * -offset
                }

                TabLayoutMediator(tlHomeBannerIndicator, vpHomeBanner) { tab, position ->
                }.attach()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}