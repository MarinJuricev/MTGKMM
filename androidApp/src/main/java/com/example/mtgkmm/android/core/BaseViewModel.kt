package com.example.mtgkmm.android.core

import androidx.lifecycle.ViewModel

const val TIMEOUT_DELAY = 5_000L

abstract class BaseViewModel<T> : ViewModel() {

    abstract fun onEvent(event: T)
}