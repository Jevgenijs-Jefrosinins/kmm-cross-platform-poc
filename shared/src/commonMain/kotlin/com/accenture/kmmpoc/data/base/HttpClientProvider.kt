package com.accenture.kmmpoc.data.base

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect class HttpClientProvider() {

    fun provideHttpClient(config: HttpClientConfig<*>.() -> Unit = baseHttpClientConfig): HttpClient
}

val baseHttpClientConfig: HttpClientConfig<*>.() -> Unit = {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
}