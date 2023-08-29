package com.shoppi.app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shoppi.app.R
import com.shoppi.app.util.logD

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<View>(R.id.btn_product_detail)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_product_detail)
        }

        val assetLoader = AssetLoader()
        assetLoader.getJsonString(requireContext(), "home.json")?.let {
            logD(it)
        }
    }
}