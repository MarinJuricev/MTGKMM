package com.example.mtgkmm.core

sealed interface Failure {
    data class ErrorMessage(val message: String) : Failure
    object UnknownError : Failure
}
