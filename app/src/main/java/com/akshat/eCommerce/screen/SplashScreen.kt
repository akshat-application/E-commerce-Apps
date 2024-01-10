package com.akshat.eCommerce.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    var splashScreenCompleted by remember { mutableStateOf(false) }
//    LaunchedEffect(true) {
//        countDown()
//            .onEach { count ->
//                if (count >= 100) {
//                    splashScreenCompleted = true
//                    coroutineContext.cancel() // cancel the coroutine when done
//                }
//            }
//            .launchIn(this)
//    }
//    if (splashScreenCompleted) {
//
//    } else {
//        Box(Modifier.fillMaxSize().background(color = Color.Blue)) {
//        }
    onTimeout.invoke()
//    }

}

fun countDown(): Flow<Long> = flow {
    var count = 0L
    while (true) {
        delay(10) // wait for 10 milliseconds
        emit(count) // emit the current count value
        count++
    }
}