package com.comforttech.smartexpense.View.Screens

import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.comforttech.smartexpense.View.Navigations.NavigationManager
import com.comforttech.smartexpense.R

@Composable
fun Splash(navigationManager: NavigationManager){

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Logo")

    }

}