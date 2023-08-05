package com.accenture.kmmpoc.presentation.base.di

import android.content.Context
import com.accenture.kmmpoc.presentation.base.BaseActivity
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider

fun baseActivityModule(activity: BaseActivity) = DI.Module("baseActivityModule") {
    bind<Context>() with provider { activity }
    bind<BaseActivity>() with provider { activity }
}