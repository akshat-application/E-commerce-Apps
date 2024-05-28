package com.akshat.eCommerce

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshat.eCommerce.navigation.RootItems
import com.akshat.eCommerce.screen.DashboardScreen
import com.akshat.eCommerce.screen.LoginScreen
import com.akshat.eCommerce.screen.SignUpScreen
import com.akshat.eCommerce.screen.SplashScreen
import com.akshat.eCommerce.ui.theme.eCommerceTheme
import com.akshat.eCommerce.utils.AppConstant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            var isNetwork by remember { mutableStateOf(isNetworkAvailable(this@MainActivity)) }
            eCommerceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    if (isNetwork) {
                        AppNavHost(navController = navController)
                    } else {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(color = Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(4.dp)
                                    .align(Alignment.Center)
                            ) {
                                Text(
                                    text = AppConstant.NO_INTERNET_DIALOG,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Black
                                )
                                Box(
                                    Modifier
                                        .padding(4.dp)
                                        .background(color = Color.Blue)
                                        .clickable {
                                            isNetwork = isNetworkAvailable(this@MainActivity)
                                        }.align(Alignment.CenterHorizontally)
                                ) {
                                    Text(
                                        modifier = Modifier.background(
                                            color = MaterialTheme.colorScheme.primary,
                                            shape = RoundedCornerShape(4.dp)
                                        ),
                                        text = AppConstant.RETRY,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val networkCapabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo != null && networkInfo.isConnected
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var isSplashScreenFinished by rememberSaveable {
        mutableStateOf(false)
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = if (isSplashScreenFinished) {
            RootItems.Login.route
        } else {
            RootItems.Splash.route
        }
    ) {
        composable(RootItems.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(RootItems.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(RootItems.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(RootItems.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
    }
}