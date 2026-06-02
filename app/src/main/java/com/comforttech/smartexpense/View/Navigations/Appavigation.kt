package com.comforttech.smartexpense.View.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.comforttech.smartexpense.View.Screens.Dashboard
import com.comforttech.smartexpense.View.Screens.Splash


@Composable
fun Appavigation(

    navController: NavHostController,
    navigationManager:NavigationManager
) {

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.routeString ){

         composable(NavigationScreen.SplashScreen.routeString){
             Splash(navigationManager)
         }

        composable(NavigationScreen.DashboardScreen.routeString){
            Dashboard(navigationManager = navigationManager )
        }

    }
}