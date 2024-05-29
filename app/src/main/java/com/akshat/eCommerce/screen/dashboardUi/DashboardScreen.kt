package com.akshat.eCommerce.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akshat.eCommerce.R
import com.akshat.eCommerce.utils.AppConstant

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    BottomItems()
}

@Composable
fun BottomItems() {
    var iconOnClick by remember {
        mutableStateOf(AppConstant.ICONHOME)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth().navigationBarsPadding()
            .padding(start = 4.dp, end = 4.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(modifier = Modifier
            .clickable { iconOnClick = AppConstant.ICONHOME }
            .background(if (iconOnClick == AppConstant.ICONHOME) Color.Blue else Color.White)) {
            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "pen icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                colorFilter = if (iconOnClick == AppConstant.ICONHOME) ColorFilter.tint(Color.White) else ColorFilter.tint(
                    MaterialTheme.colorScheme.primary
                )
            )
        }
        Box(modifier = Modifier
            .clickable { iconOnClick = AppConstant.ICONUSER }
            .background(if (iconOnClick == AppConstant.USER_NAME) Color.Blue else Color.White)) {
            Image(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "pen icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                colorFilter = if (iconOnClick == AppConstant.ICONUSER) ColorFilter.tint(Color.White) else ColorFilter.tint(
                    MaterialTheme.colorScheme.primary
                )
            )
        }
        Box(modifier = Modifier
            .clickable { iconOnClick = AppConstant.ICONMORE }
            .background(if (iconOnClick == AppConstant.ICONMORE) Color.Blue else Color.White)) {
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "pen icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                colorFilter = if (iconOnClick == AppConstant.ICONMORE) ColorFilter.tint(Color.White) else ColorFilter.tint(
                    MaterialTheme.colorScheme.primary
                )
            )
        }
        Box(modifier = Modifier
            .clickable { iconOnClick = AppConstant.ICONCART }
            .background(if (iconOnClick == AppConstant.ICONCART) Color.Blue else Color.White)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_shopping_cart_24),
                contentDescription = "pen icon",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp),
                colorFilter = if (iconOnClick == AppConstant.ICONCART) ColorFilter.tint(Color.White) else ColorFilter.tint(
                    MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}