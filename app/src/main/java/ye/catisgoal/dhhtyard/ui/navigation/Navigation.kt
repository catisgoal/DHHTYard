package ye.catisgoal.dhhtyard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ye.catisgoal.dhhtyard.MainBtmNavigationRoutes
import ye.catisgoal.dhhtyard.ui.screens.collection.CollectionScreen
import ye.catisgoal.dhhtyard.ui.screens.explore.ExploreScreen

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavigationVM.startDestination.value
    ) {
        composable(route = MainBtmNavigationRoutes.EXPLORE.name) {
            ExploreScreen(mainNavController = navController)
        }
        composable(route = MainBtmNavigationRoutes.SETTINGS.name) {
        }
        composable(route = MainBtmNavigationRoutes.COLLECTION.name) {
            CollectionScreen()

        }
    }

}