package com.accenture.kmmpoc.domain.base

sealed class DomainResponse<out T : Any> {
    object Loading : DomainResponse<Nothing>()
    data class Content<out T : Any>(val result: T) : DomainResponse<T>()
    data class Error<out T : Any>(val code: Int, val message: String) : DomainResponse<T>()
}

@Suppress("TooGenericExceptionCaught")
suspend fun <T : Any> domainResponse(
    result: suspend () -> T
) =
    try {
        DomainResponse.Content(result())
    } catch (e: Exception) {
        // TODO replace with meaningful handler (e.g. provide Http Error code from Ktor)
        DomainResponse.Error(999, "${e.message}")
    }
