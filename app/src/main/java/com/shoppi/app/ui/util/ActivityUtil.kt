package com.shoppi.app.ui.util

import android.app.Activity
import timber.log.Timber

fun Activity.logD(message: String) {
    Timber.d("$localClassName: $message")
}

fun Activity.logE(message: String, throwable: Throwable? = null) {
    Timber.e(throwable, "$localClassName: $message")
}
