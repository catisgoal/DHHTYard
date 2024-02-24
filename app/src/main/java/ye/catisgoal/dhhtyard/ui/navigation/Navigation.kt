package ye.catisgoal.dhhtyard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ye.catisgoal.dhhtyard.ui.screens.HomeScreen

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavigationVM.startDestination.value
    ) {
        composable(route = NavigationRoutes.EXPLORE.name) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationRoutes.SETTINGS.name) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationRoutes.LIBRARY.name) {
            HomeScreen(navController = navController)
        }
    }

}