package com.comforttech.smartexpense.View.Screens

import android.view.animation.OvershootInterpolator
import android.window.SplashScreenView
import androidx.compose.animation.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.comforttech.smartexpense.View.Navigations.NavigationManager
import com.comforttech.smartexpense.R
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.comforttech.smartexpense.ui.theme.WindowSize
import com.comforttech.smartexpense.ui.theme.colorBlue
import com.comforttech.smartexpense.ui.theme.colorpurple
import com.comforttech.smartexpense.ui.theme.rememberWindowSize
import kotlinx.coroutines.delay

@Composable
fun Splash(navigationManager: NavigationManager){

    val windowSize = rememberWindowSize()

    val scale = remember {
        Animatable(0f)
    }

    val text = "SpendSmart"
    
    LaunchedEffect(Unit){
        scale.animateTo(targetValue = 1f, animationSpec = tween(
            durationMillis = 500,
            easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
        ) )

       // delay(3000L)
        navigationManager.navigate_from_Splash_to_DashboardScreen()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorBlue)){


        when (windowSize) {

            WindowSize.Compact -> {
                SplashContent(scale, iconSize = 80.dp, textSize = 26.sp)
            }

            WindowSize.Medium -> {
                SplashContent(scale, iconSize = 100.dp, textSize = 30.sp)
            }

            WindowSize.Expanded -> {
                SplashContent(scale, iconSize = 120.dp, textSize = 34.sp)
            }
        }


      /*  Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Outlined.Payments,
                contentDescription = "Coins / logo",
                modifier = Modifier
                    .size(24.dp)
                    .background(colorpurple)

            )

            Spacer(modifier = Modifier.height(12.dp))
            
            Text(text = text,
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth())
        }*/



    }
}

@Composable
fun SplashContent(
    scale: Animatable<Float, AnimationVector1D>,
    iconSize: Dp,
    textSize: TextUnit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Icon(
            imageVector = Icons.Outlined.Payments,
            contentDescription = "Coins / logo",
            tint = Color.White,
            modifier = Modifier
                .size(iconSize)
                .scale(scale.value)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "SpendSmart",
            fontSize = textSize,
            color = Color.White,
            modifier = Modifier.scale(scale.value)
        )

        Text(
            text = "Track.Understand.Save",
            fontSize = 10.sp,
            color = Color.LightGray,
            modifier = Modifier.scale(scale.value)
        )
    }
}





