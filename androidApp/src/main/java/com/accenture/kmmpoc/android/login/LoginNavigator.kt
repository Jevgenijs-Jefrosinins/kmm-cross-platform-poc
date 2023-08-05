package com.accenture.kmmpoc.android.login

import com.accenture.kmmpoc.android.MainActivity
import com.accenture.kmmpoc.presentation.navigation.BaseNavigator

class LoginNavigator(activity: LoginActivity): BaseNavigator(activity) {
    override fun navigateBack(): Boolean {
        return false
    }

    fun toHomePage() = navigateToActivity(
        targetActivityClass = MainActivity::class.java,
        shouldFinish = true
    )
}