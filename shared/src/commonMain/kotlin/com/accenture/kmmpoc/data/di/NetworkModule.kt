package com.accenture.kmmpoc.data.di

import com.accenture.kmmpoc.data.auth.AuthApiService
import com.accenture.kmmpoc.data.base.Environment
import com.accenture.kmmpoc.data.base.HttpClientProvider
import com.accenture.kmmpoc.data.home.ProductsApiService
import io.ktor.client.*
import org.kodein.di.*

val networkModule = DI.Module("NetworkModule") {
    bind<HttpClient>() with provider { HttpClientProvider().provideHttpClient() }
    bind<Environment>() with singleton { Environment.PRODUCTION }

    bind<AuthApiService>() with provider { AuthApiService(instance(), instance()) }
    bind<ProductsApiService>() with provider { ProductsApiService(instance(), instance()) }
}