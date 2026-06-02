package com.comforttech.smartexpense.View.Navigations

sealed class NavigationScreen(val routeString: String){

    object SplashScreen:NavigationScreen("SplashScreen")

    object DashboardScreen:NavigationScreen("Dashboard")


}
