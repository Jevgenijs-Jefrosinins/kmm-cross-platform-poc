@file:JvmName("HttpClientProviderJvm")

package com.accenture.kmmpoc.data.base

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 5L

actual class HttpClientProvider {

    actual fun provideHttpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(OkHttp) {
        config(this)

        engine {
            config {
                retryOnConnectionFailure(true)
                connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            }
        }
    }
}
