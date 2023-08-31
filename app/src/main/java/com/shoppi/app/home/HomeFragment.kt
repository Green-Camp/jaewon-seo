package com.shoppi.app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.shoppi.app.databinding.FragmentHomeBinding
import com.shoppi.app.home.adapter.HomeBannerAdapter
import com.shoppi.app.home.data.Banner
import com.shoppi.app.home.data.BannerBadge
import com.shoppi.app.home.data.HomeData
import com.shoppi.app.home.data.Title
import com.shoppi.app.home.module.GlideApp
import org.json.JSONObject

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "binding is null" }


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
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString,HomeData::class.java)

            with(binding) {
                tvHomeTitleText.text = homeData.title.text

                GlideApp.with(requireContext())
                    .load(homeData.title.iconUrl)
                    .into(ivHomeTitleLogo)

                vpHomeBanner.adapter = HomeBannerAdapter().apply {
                    submitList(homeData.topBanner)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}