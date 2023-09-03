package com.shoppi.app.ui.home.data

import com.google.gson.annotations.SerializedName

data class HomeData(
    val title: Title,
    @SerializedName("top_banners")
    val topBanner: List<Banner>
)
