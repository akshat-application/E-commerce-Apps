package com.akshat.eCommerce.navigation


enum class Screen {
    SPLASH,
    LOGIN,
    SIGNUP,
    DASHBOARD
}

sealed class RootItems(val route: String) {
    object Splash : RootItems(Screen.SPLASH.name)
    object Login : RootItems(Screen.LOGIN.name)
    object SignUp : RootItems(Screen.SIGNUP.name)
    object Dashboard : RootItems(Screen.DASHBOARD.name)
}