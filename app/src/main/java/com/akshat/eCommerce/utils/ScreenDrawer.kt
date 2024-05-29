package com.akshat.eCommerce.utils

import com.akshat.eCommerce.R

sealed class ScreenDrawer(val route: String, val title: String, val id: Int) {
    object Home : ScreenDrawer(AppConstant.HOME, AppConstant.HOME, R.drawable.ic_home)
    object Settings : ScreenDrawer(AppConstant.SETTINGS, AppConstant.SETTINGS, R.drawable.ic_settings)
    object About : ScreenDrawer(AppConstant.ABOUT, AppConstant.ABOUT, R.drawable.ic_about)
    object Logout : ScreenDrawer(AppConstant.LOGOUT, AppConstant.LOGOUT, R.drawable.ic_logout)
}