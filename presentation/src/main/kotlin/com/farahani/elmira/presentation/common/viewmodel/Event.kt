package com.farahani.elmira.presentation.common.viewmodel

import androidx.lifecycle.Observer

/**
 * Created by elmira on 17, March, 2020
 */
open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    @Synchronized
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled)
            null
        else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let(onEventUnhandledContent)
    }
}
