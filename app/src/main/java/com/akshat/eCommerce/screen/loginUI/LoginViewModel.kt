package com.akshat.eCommerce.screen.loginUI

import android.content.Context
import com.akshat.eCommerce.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    @ApplicationContext applicationContext: Context
): BaseViewModel(applicationContext) {
}