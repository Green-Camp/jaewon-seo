package com.shoppi.app.ui.util

import androidx.fragment.app.Fragment
import timber.log.Timber

fun Fragment.logD(message: String) {
    Timber.d("${javaClass.simpleName}: $message")
}

fun Fragment.logE(message: String, throwable: Throwable? = null) {
    Timber.e(throwable, "${javaClass.simpleName}: $message")
}