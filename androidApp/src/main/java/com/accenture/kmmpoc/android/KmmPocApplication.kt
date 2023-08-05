package com.accenture.kmmpoc.android

import android.app.Application
import android.content.Context
import com.accenture.kmmpoc.data.di.app
import com.accenture.kmmpoc.data.di.appContext
import com.accenture.kmmpoc.data.di.repositoryModule
import com.accenture.kmmpoc.domain.di.useCaseModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bind
import org.kodein.di.singleton

open class KmmPocApplication: Application(), DIAware {
    override val di: DI
        get() =  DI.lazy {
            import(androidXModule(this@KmmPocApplication))
            importOnce(repositoryModule)
            importOnce(useCaseModule)

            bind<Application>(tag = app) with singleton { this@KmmPocApplication }
            bind<Context>(tag = appContext) with singleton { this@KmmPocApplication }
        }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //TODO e.g. initialize logs for debug builds
        }
    }
}