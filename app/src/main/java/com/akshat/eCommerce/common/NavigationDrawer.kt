package com.akshat.eCommerce.common

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.akshat.eCommerce.ui.theme.colorError700
import com.akshat.eCommerce.ui.theme.colorTextDarkGray
import com.akshat.eCommerce.utils.ScreenDrawer

@Composable
fun NavigationDrawer(
    navController: NavController,
    context: Context,
    currentScreen: ScreenDrawer,
    drawerItems: List<ScreenDrawer>,
    onDrawerItemClicked: (ScreenDrawer?) -> Unit
) {
    Column(
        modifier = Modifier.background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.secondary)
        ) {
            val borderRadius = 16.dp
            val borderStrokeWidth = .01.dp
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .align(Alignment.Center)
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            borderStrokeWidth,
                            Color.Black,
                            RoundedCornerShape(borderRadius)
                        )
                        .height(50.dp)
                        .width(50.dp)
                        .size(5.dp)
                        .align(Alignment.CenterVertically),
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .allowHardware(false)
                            .crossfade(true)
                            .build(),
                        contentDescription = "User profile pic",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clip(CircleShape)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 30.dp)
                ) {
                    Text(
                        text = "abc",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "dfdf",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "fdfdfd",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier.size(8.dp)
        )
        drawerItems.forEach { screen ->
            if (screen == ScreenDrawer.Logout) {
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .clickable {
                            onDrawerItemClicked.invoke(screen)
                        }
                        .fillMaxWidth()
                        .shadow(elevation = 8.dp)
                        .background(colorError700)
                        .padding(start = 8.dp)
                        .padding(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = screen.id),
                        contentDescription = "Navigation Item Logo",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                    Text(
                        text = screen.title,
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Gray),
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .clickable {
                            if (screen == currentScreen) {
                                onDrawerItemClicked.invoke(screen)
                            } else {
                                onDrawerItemClicked.invoke(null)
                                navController.navigate(
//                                    todo root build
                                    ""
                                )
                            }
                        }
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = if (screen == currentScreen) 8.dp else 0.dp,
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                bottomStart = 8.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(
                            color = if (screen == currentScreen) MaterialTheme.colorScheme.primary else Color.Transparent,
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                bottomStart = 8.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .padding(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically),
                        painter = painterResource(id = screen.id),
                        contentDescription = "Navigation Item Logo",
                        colorFilter = if (screen == currentScreen) ColorFilter.tint(Color.White) else ColorFilter.tint(
                            colorTextDarkGray
                        )
                    )
                    Text(
                        text = screen.title,
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Gray),
                        fontSize = 14.sp,
                        color = if (screen == currentScreen) Color.White else colorTextDarkGray
                    )
                }
            }
        }
    }
}