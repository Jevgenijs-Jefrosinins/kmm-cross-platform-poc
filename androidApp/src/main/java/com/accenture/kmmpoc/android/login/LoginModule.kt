package com.accenture.kmmpoc.android.login

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider

fun loginModule(activity: LoginActivity) = DI.Module("loginModule") {
    bind<LoginNavigator>() with provider { LoginNavigator(activity) }
}