package com.comforttech.smartexpense.View.Navigations

sealed class NavigationScreen(val routeString: String){

    object SplashScreen:NavigationScreen("SplashScreen")

    object DashboardScreen:NavigationScreen("Dashboard")

    object AnalyticsScreen:NavigationScreen("Analytics")

    object BudgetScreen:NavigationScreen("Budget")

    object CategoryScreen:NavigationScreen("Category")

    object SettingScreen:NavigationScreen("Settings")

    object AddExpenseScreen : NavigationScreen("AddExpense")


}
