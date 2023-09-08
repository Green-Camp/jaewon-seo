package com.shoppi.app.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shoppi.app.common.ViewModelFactory
import com.shoppi.app.databinding.FragmentCategoryBinding
import com.shoppi.app.ui.category.adapter.CategoryAdapter
import com.shoppi.app.util.logD

class CategoryFragment : Fragment() {
    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter()
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            logD("items: ${it.toString()}")
            categoryAdapter.submitList(it)
        }
    }
}