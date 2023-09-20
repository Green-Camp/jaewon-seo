package com.shoppi.app.ui.categordetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Promotion
import com.shoppi.app.model.TopSelling
import com.shoppi.app.repository.categorydetail.CategoryDetailRepository
import kotlinx.coroutines.launch

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository
) : ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions = _promotions

    init{
        loadCategoryDetail()
    }

    private fun loadCategoryDetail(){
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}