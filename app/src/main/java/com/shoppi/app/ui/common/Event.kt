package com.shoppi.app.ui.common

import androidx.lifecycle.Observer

// Livedata를 통해서 이벤트를 전달할 때, 이벤트가 한번만 전달되도록 하기 위한 클래스
class Event<T>(private val content: T) {

    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>) {
        event?.getContentIfNotHandled()?.let{
            onEventUnhandledContent(it)
        }
    }
}