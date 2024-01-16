package com.akshat.eCommerce.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.akshat.eCommerce.screen.dashboardUi.DashBoardViewModel

@Composable
fun DashboardScreen(
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

@Composable
fun BottomItems() {
    var isClicked by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.clickable {isClicked =! isClicked }.background(if (isClicked) Color.Blue else Color.White)) {

        }
    }
}