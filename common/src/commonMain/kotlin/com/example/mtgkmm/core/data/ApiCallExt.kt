package com.example.mtgkmm.core.data

import com.example.mtgkmm.core.Either
import com.example.mtgkmm.core.Failure
import com.example.mtgkmm.core.buildLeft
import com.example.mtgkmm.core.buildRight
import io.ktor.client.HttpClient
import io.ktor.utils.io.errors.IOException

suspend fun <T> HttpClient.apiCall(
    block: suspend (HttpClient) -> T,
): Either<Failure, T> {
    return try {
        block(this).buildRight()
    } catch (exception: IOException) {
        (exception.message?.let { errorMessage ->
            Failure.ErrorMessage(errorMessage)
        } ?: Failure.UnknownError).buildLeft()
    } catch (exception: Throwable) {
        Failure.UnknownError.buildLeft()
    }
}
