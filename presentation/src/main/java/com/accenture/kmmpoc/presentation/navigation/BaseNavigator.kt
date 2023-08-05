package com.accenture.kmmpoc.presentation.navigation

import android.content.Intent
import android.os.Bundle
import com.accenture.kmmpoc.presentation.base.BaseActivity

const val NO_REQUEST = -1

abstract class BaseNavigator(protected val activity: BaseActivity) {

    /**
     * Implementation should return true if custom "Back" navigation is required
     * (e.g., change Activity's content instead of invoking onBackPressed())
     */
    open fun navigateBack(): Boolean {
        return false
    }

    protected fun navigateToActivity(
        targetActivityClass: Class<out BaseActivity>,
        extras: Bundle? = null,
        requestCode: Int = NO_REQUEST,
        shouldFinish: Boolean = false
    ) {
        with (activity) {
            val intent = Intent(activity, targetActivityClass)
            extras?.let { intent.putExtras(it) }
            if (requestCode > 0) {
                startActivityForResult(intent, requestCode)
            } else {
                startActivity(intent)
            }
            if (shouldFinish) finish()
        }
    }

}