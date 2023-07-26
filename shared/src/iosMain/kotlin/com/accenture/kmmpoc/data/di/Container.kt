package com.accenture.kmmpoc.data.di

import com.accenture.kmmpoc.domain.auth.SignInUseCase
import com.accenture.kmmpoc.domain.di.useCaseModule
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Container {

    val di = DI.lazy {
        importOnce(useCaseModule)
        importOnce(repositoryModule)
    }

    //Convenience methods for DI in iOS/Swift code
    // these are required because Kotlin/Native compiler does not support [reified generics]
    // and hence Kodein's [instance()] methods are unavailable in [.framework] binary
    fun getSignInUseCase() = di.direct.instance<SignInUseCase>()
}