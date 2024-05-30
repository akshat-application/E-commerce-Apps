package com.akshat.eCommerce.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akshat.eCommerce.R
import com.akshat.eCommerce.common.CustomTopAppBar
import com.akshat.eCommerce.common.NavigationDrawer
import com.akshat.eCommerce.ui.theme.newButtonStyle
import com.akshat.eCommerce.utils.AppConstant
import com.akshat.eCommerce.utils.ScreenDrawer
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    fun customDrawerShape() = object : Shape {
        override fun createOutline(
            size: Size,
            layoutDirection: LayoutDirection,
            density: Density
        ): Outline {
            return Outline.Rectangle(Rect(0f, 0f, 700f,/* width */ 10000f  /* height */))
        }
    }

    val drawerItems = listOf(
        ScreenDrawer.Home,
        ScreenDrawer.Settings,
        ScreenDrawer.About,
        ScreenDrawer.Logout
    )
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = @androidx.compose.runtime.Composable {
            CustomTopAppBar(
                title = AppConstant.APP_TITLE,
                onNavigationClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                actionIcon = {
//                    Icon(
//                        imageVector = Icons.Filled.Refresh,
//                        contentDescription = "refresh button",
//                        tint = Color.White
//                    )
                },
                onActionClicked = {}
            )
        },
        scaffoldState = scaffoldState,
        drawerShape = customDrawerShape(),
        drawerContent = {
            // Composable for the drawer content
            NavigationDrawer(
                navController = navController,
                context = context,
                currentScreen = ScreenDrawer.Home,
                drawerItems = drawerItems
            ) { thisScreen ->

                thisScreen?.let {

                }
            }
        },
    )
    { scaffoldPadding ->
        val screenPadding = scaffoldPadding

    }
    BottomItems()
}

@Composable
fun BottomItems() {
    var iconOnClick by remember {
        mutableStateOf(AppConstant.ICONHOME)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .clickable { iconOnClick = AppConstant.ICONHOME }
            .background(if (iconOnClick == AppConstant.ICONHOME) Color.Blue else Color.White)) {

            Column(modifier = Modifier.align(Alignment.Center)) {
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
                Text(
                    text = AppConstant.HOME,
                    style = newButtonStyle,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

        }
        Box(modifier = Modifier
            .weight(1f)
            .clickable { iconOnClick = AppConstant.ICONUSER }
            .background(if (iconOnClick == AppConstant.ICONUSER) Color.Blue else Color.White)) {
            Column(modifier = Modifier.align(Alignment.Center)) {
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
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = AppConstant.YOU,
                    style = newButtonStyle
                )
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .clickable { iconOnClick = AppConstant.ICONMORE }
            .background(if (iconOnClick == AppConstant.ICONMORE) Color.Blue else Color.White)) {
            Column(modifier = Modifier.align(Alignment.Center)) {
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
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = AppConstant.MORE,
                    style = newButtonStyle
                )
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .clickable { iconOnClick = AppConstant.ICONCART }
            .background(if (iconOnClick == AppConstant.ICONCART) Color.Blue else Color.White)) {
            Column(modifier = Modifier.align(Alignment.Center)) {
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
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = AppConstant.CART,
                    style = newButtonStyle
                )
            }
        }
    }
}