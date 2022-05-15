package com.example.mtgkmm.android.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    abstract fun onEvent(event: T)
}