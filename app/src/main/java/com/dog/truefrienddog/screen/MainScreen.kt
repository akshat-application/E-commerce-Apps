package com.dog.truefrienddog.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {

    }
}