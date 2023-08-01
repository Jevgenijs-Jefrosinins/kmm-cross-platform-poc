package com.accenture.kmmpoc.data.di

import com.accenture.kmmpoc.data.auth.AuthApiDataSource
import com.accenture.kmmpoc.data.home.ProductsApiDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val apiDataSourceModule = DI.Module("ApiDataSourceModule") {
    importOnce(networkModule)

    bind<AuthApiDataSource>() with provider { AuthApiDataSource(instance()) }
    bind<ProductsApiDataSource>() with provider { ProductsApiDataSource(instance()) }
}