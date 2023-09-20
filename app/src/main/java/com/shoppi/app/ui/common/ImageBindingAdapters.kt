package com.shoppi.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty())
        view.load(imageUrl)
}

@BindingAdapter("circleImageUrl")
fun loadCircleImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty())
        view.load(imageUrl) {
            transformations(CircleCropTransformation())
        }
}