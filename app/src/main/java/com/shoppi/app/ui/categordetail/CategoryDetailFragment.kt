package com.shoppi.app.ui.categordetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import com.shoppi.app.common.KEY_CATEGORY_LABEL
import com.shoppi.app.databinding.FragmentCategoryDetailBinding
import com.shoppi.app.ui.categordetail.adapter.CategoryPromotionAdapter
import com.shoppi.app.ui.categordetail.adapter.CategorySectionTitleAdapter

class CategoryDetailFragment : Fragment() {
    private lateinit var binding: FragmentCategoryDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolBar()
        setListAdapter()
    }

    private fun setToolBar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.tbCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter() {
        val titleAdapter = CategorySectionTitleAdapter()
        val promotionAdapter = CategoryPromotionAdapter()
        binding.rvCategoryDetail.adapter = ConcatAdapter(titleAdapter, promotionAdapter)
    }
}