package com.shoppi.app.ui.home.data

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String = "",
    @SerializedName("icon_url")
    val iconUrl: String = ""
)