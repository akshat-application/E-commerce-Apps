package com.dog.truefrienddog.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

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