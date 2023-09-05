package com.shoppi.app.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url")
    val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail")
    val productDetail: ProductDetail
)

data class BannerBadge(
    val label: String,
    @SerializedName("background_color")
    val backgroundColor: String
)

data class ProductDetail(
    @SerializedName("brand_name")
    val brandName: String,
    val label: String,
    @SerializedName("discount_rate")
    val discountRate: Int,
    @SerializedName("thumbnail_image_url")
    val thumbnailImageUrl: String,
    val price: Int,
    @SerializedName("original_price")
    val productId: String
)