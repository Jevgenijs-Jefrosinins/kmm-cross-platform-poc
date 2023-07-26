package com.accenture.kmmpoc.data.di

import com.accenture.kmmpoc.data.auth.AuthRepositoryImpl
import com.accenture.kmmpoc.domain.auth.AuthRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val repositoryModule = DI.Module("RepositoryModule") {
    importOnce(apiDataSourceModule)

    bind<AuthRepository>() with provider { AuthRepositoryImpl(instance()) }
}