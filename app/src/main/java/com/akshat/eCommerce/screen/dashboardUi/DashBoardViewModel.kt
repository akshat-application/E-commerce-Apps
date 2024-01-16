package com.akshat.eCommerce.screen.dashboardUi

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(
    @ApplicationContext context: Context): ViewModel() {

}