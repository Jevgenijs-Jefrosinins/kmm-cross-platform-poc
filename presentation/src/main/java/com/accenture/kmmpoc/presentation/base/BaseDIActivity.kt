package com.accenture.kmmpoc.presentation.base

import android.os.Bundle
import com.accenture.kmmpoc.presentation.base.di.baseActivityModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.closestDI
import org.kodein.di.android.retainedDI

abstract class BaseDIActivity : BaseActivity(), DIAware {

    private val parentDI: DI by closestDI()

    override val di: DI by retainedDI {
        extend(parentDI)
        import(
            module = baseActivityModule(this@BaseDIActivity),
            allowOverride = true
        )
        // initiates DI for activity-specific bindings
        // (e.g. imports separate module)
        initActivityDI()
    }

    override val diTrigger = DITrigger()

    protected abstract val initActivityDI: DI.Builder.() -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diTrigger.trigger()
    }
}