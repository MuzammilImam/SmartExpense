package com.comforttech.smartexpense.View.Navigations

import androidx.navigation.NavHostController

class NavigationManager(private val navController:NavHostController) {

      fun navigate_from_Splash_to_DashboardScreen(){
          navController.navigate(NavigationScreen.DashboardScreen.routeString){

              popUpTo(NavigationScreen.SplashScreen.routeString){
                  inclusive = true
              }
              launchSingleTop = true
              restoreState = true
          }
      }

}