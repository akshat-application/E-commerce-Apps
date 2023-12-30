package com.dog.truefrienddog.navigation


enum class Screen {
    SPLASH,
    MAIN,
    MATCH,
}

sealed class RootItems(val route: String) {
    object Splash : RootItems(Screen.SPLASH.name)
    object MainScreen : RootItems(Screen.MAIN.name)
    object MatchScreen : RootItems(Screen.MATCH.name)
}