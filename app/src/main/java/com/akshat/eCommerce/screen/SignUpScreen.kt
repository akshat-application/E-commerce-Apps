package com.akshat.eCommerce.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.akshat.eCommerce.navigation.RootItems

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
//        navController.navigate(RootItems.Login.route)
//        navController.navigate(RootItems.SignUp.route)
    }
}