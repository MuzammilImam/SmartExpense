package com.comforttech.smartexpense.View.Navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.comforttech.smartexpense.R
import com.comforttech.smartexpense.View.BottomNavigation.NavItem
import com.comforttech.smartexpense.View.Screens.AddExpense
import com.comforttech.smartexpense.View.Screens.Analytics
import com.comforttech.smartexpense.View.Screens.Dashboard
import com.comforttech.smartexpense.View.Screens.Splash
import com.comforttech.smartexpense.ui.theme.colorBlue


@Composable
fun Appavigation(

    navController: NavHostController,
    navigationManager:NavigationManager
) {

    val currentRoute = navController
                                .currentBackStackEntryAsState()
                                .value
                                ?.destination
                                ?.route

    val bottomBarScreens = setOf(
        NavigationScreen.DashboardScreen.routeString,
        NavigationScreen.AnalyticsScreen.routeString,
        NavigationScreen.BudgetScreen.routeString
    )

    val showBottomBar = currentRoute in bottomBarScreens


    val showFab =
        currentRoute == NavigationScreen.DashboardScreen.routeString

    Scaffold(

        bottomBar = {
            if (showBottomBar) {
                BottomBar(
                    navController = navController
                )
            }
        },

        floatingActionButton = {

            if (showFab) {

                FloatingActionButton(
                    onClick = {
                        // Add expense
                              navigationManager.navigateToAddExpense()
                    },
                    containerColor = colorBlue
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        })
    { padding ->

        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = NavigationScreen.SplashScreen.routeString ){

            composable(NavigationScreen.SplashScreen.routeString){
                Splash(navigationManager)
            }

            composable(NavigationScreen.DashboardScreen.routeString){
                Dashboard(navigationManager = navigationManager )
            }

            composable(NavigationScreen.AddExpenseScreen.routeString){
                AddExpense(navController = navController)
            }

            composable(NavigationScreen.AnalyticsScreen.routeString){
                Analytics()
            }

        }
    }

    /*NavHost(
        navController = navController,
        startDestination = NavigationScreen.SplashScreen.routeString ){

         composable(NavigationScreen.SplashScreen.routeString){
             Splash(navigationManager)
         }

        composable(NavigationScreen.DashboardScreen.routeString){
            Dashboard(navigationManager = navigationManager )
        }

    }*/
}

@Composable
fun BottomBar(navController: NavHostController) {

    val currentRoute =
        navController.currentBackStackEntryAsState()
            .value
            ?.destination
            ?.route


    val navItemList = listOf(

        NavItem(
            stringResource(R.string.NavHome),
            Icons.Default.Home,
            NavigationScreen.DashboardScreen.routeString
        ),

        NavItem(
            stringResource(R.string.NavAnalytics),
            Icons.Default.BarChart,
            NavigationScreen.AnalyticsScreen.routeString
        ),

        NavItem(
            stringResource(R.string.NavBudget),
            Icons.Default.AccountBalanceWallet,
            NavigationScreen.BudgetScreen.routeString
        ),

        NavItem(
            stringResource(R.string.NavCategories),
            Icons.Default.Category,
            NavigationScreen.CategoryScreen.routeString
        ),

        NavItem(
            stringResource(R.string.NavSettings),
            Icons.Default.Settings,
            NavigationScreen.SettingScreen.routeString
        )
    )

    NavigationBar {

        navItemList.forEach { navItem ->

            NavigationBarItem(

                selected = currentRoute == navItem.route,

                onClick = {

                    if (currentRoute != navItem.route) {

                        navController.navigate(navItem.route) {

                            popUpTo(
                                navController.graph.startDestinationId
                            ) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },

                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.label
                    )
                },

                label = {
                    Text(navItem.label)
                }
            )
        }
    }
}