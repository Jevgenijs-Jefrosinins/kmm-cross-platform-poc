package com.accenture.kmmpoc.data.di

import com.accenture.kmmpoc.data.auth.AuthRepositoryImpl
import com.accenture.kmmpoc.data.home.ProductsRepositoryImpl
import com.accenture.kmmpoc.domain.auth.AuthRepository
import com.accenture.kmmpoc.domain.home.ProductsRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val repositoryModule = DI.Module("RepositoryModule") {
    importOnce(apiDataSourceModule)

    bind<AuthRepository>() with provider { AuthRepositoryImpl(instance()) }
    bind<ProductsRepository>() with provider { ProductsRepositoryImpl(instance()) }
}