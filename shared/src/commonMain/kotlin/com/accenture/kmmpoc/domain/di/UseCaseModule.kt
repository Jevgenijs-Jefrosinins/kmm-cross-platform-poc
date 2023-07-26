package com.accenture.kmmpoc.domain.di

import com.accenture.kmmpoc.domain.auth.SignInUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val useCaseModule = DI.Module("UseCaseModule") {
    //TODO for Android - dependency modules should be imported in application class

    bind<SignInUseCase>() with provider { SignInUseCase(instance()) }
}