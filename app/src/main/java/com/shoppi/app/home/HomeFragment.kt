package com.shoppi.app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shoppi.app.databinding.FragmentHomeBinding
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
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")

        if (!homeData.isNullOrEmpty()) {
            val jsonObject = JSONObject(homeData)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleValue = Title(text, iconUrl)

            with(binding) {
                tvHomeTitleText.text = titleValue.text

                //Coil
                //ivHomeTitleLogo.load(iconUrl)

                //Glide
                GlideApp.with(requireContext())
                    .load(iconUrl)
                    .into(ivHomeTitleLogo)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}