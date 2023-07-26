package com.accenture.kmmpoc.android

import android.app.Application
import com.accenture.kmmpoc.data.di.repositoryModule
import com.accenture.kmmpoc.domain.di.useCaseModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

open class KmmPocApplication: Application(), DIAware {
    override val di: DI
        get() =  DI.lazy {
            import(androidXModule(this@KmmPocApplication))
            importOnce(repositoryModule)
            importOnce(useCaseModule)
        }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //TODO e.g. initialize logs for debug builds
        }
    }
}