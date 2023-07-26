package com.accenture.kmmpoc.data.base

import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual class HttpClientProvider {
    actual fun provideHttpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Darwin) {
        config(this)

        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
    }
}