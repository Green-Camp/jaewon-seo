package com.shoppi.app.ui.common

import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun updateVisibility(view: android.view.View, isVisible: Boolean) {
    view.visibility = if (isVisible) android.view.View.VISIBLE else android.view.View.GONE
}