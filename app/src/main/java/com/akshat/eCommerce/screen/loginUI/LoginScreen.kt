package com.akshat.eCommerce.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akshat.eCommerce.ui.theme.ButtonStyle
import com.akshat.eCommerce.utils.AppConstant

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    var userNameValue by remember {
        mutableStateOf("")
    }
    var userPasswordValue by remember {
        mutableStateOf("")
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        Box(
            Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = AppConstant.USER_NAME,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                OutlinedTextField(value = userNameValue,
                    onValueChange = {
                        userNameValue = it
                    })
                Text(
                    text = AppConstant.PASSWORD,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                OutlinedTextField(value = userPasswordValue,
                    onValueChange = {
                        userPasswordValue = it
                    })
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 20.dp),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = AppConstant.LOGIN,
                        style = ButtonStyle
                    )
                }
            }
        }
//        navController.navigate(RootItems.SignUp.route)
    }
}