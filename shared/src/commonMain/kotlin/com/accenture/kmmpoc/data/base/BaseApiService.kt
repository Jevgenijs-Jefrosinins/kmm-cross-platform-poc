package com.accenture.kmmpoc.data.base

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

open class BaseApiService(
    val client: HttpClient,
    private val environment: Environment
) {

    protected suspend inline fun <reified T> get(
        endpoint: Endpoint,
        crossinline requestConfig: HttpRequestBuilder.() -> Unit
    ): T = client.get {
        baseRequestConfig(endpoint)
        requestConfig()
    }.body()

    protected suspend inline fun <reified T> post(
        endpoint: Endpoint,
        crossinline requestConfig: HttpRequestBuilder.() -> Unit
    ): T = client.post {
        baseRequestConfig(endpoint)
        requestConfig()
    }.body()

    @PublishedApi
    internal val baseRequestConfig: HttpRequestBuilder.(Endpoint) -> Unit = {
        val endpointPath = environment.path(it)
        url {
            protocol = environment.urlProtocol
            host = environment.host
            path(endpointPath)
        }
    }
}