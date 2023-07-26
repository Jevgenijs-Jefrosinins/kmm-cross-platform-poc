package com.accenture.kmmpoc.data.base

import io.ktor.http.*

enum class Environment {

    PRODUCTION {
        override val urlProtocol: URLProtocol = URLProtocol.HTTPS
        override val host: String
            get() = "dummyjson.com"
        override val mode: String
            get() = "json"

        override fun path(endpoint: Endpoint): String {
            return when(endpoint) {
                Endpoint.SignIn -> "/auth/login"
                Endpoint.Home -> "/products"
                Endpoint.Details -> "/products" //product ID added to path dynamically
            }
        }
    };

    abstract val urlProtocol: URLProtocol
    abstract val host: String
    abstract val mode: String

    abstract fun path(endpoint: Endpoint): String
}

enum class Endpoint {
    SignIn,
    Home,
    Details
}