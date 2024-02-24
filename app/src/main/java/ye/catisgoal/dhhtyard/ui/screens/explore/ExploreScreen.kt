package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ye.catisgoal.dhhtyard.ExploreNavigationRoutes

@Composable
fun ExploreScreen(mainNavController: NavController) {
    val exploreScreenVM: ExploreScreenVM = viewModel()
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    exploreScreenVM.railNavigationList.forEach {
                        androidx.compose.material3.NavigationRailItem(
                            alwaysShowLabel = false,
                            modifier = Modifier.rotate(90f),
                            selected = currentRoute == it.navigationRoute.name,
                            onClick = {
                                if (it.navigationRoute.name != currentRoute)
                                    navController.navigate(it.navigationRoute.name)
                            },
                            icon = {
                                Column {
                                    Icon(
                                        modifier = Modifier.rotate(180f),
                                        imageVector = if (currentRoute == it.navigationRoute.name) {
                                            it.selectedIcon
                                        } else {
                                            it.nonSelectedIcon
                                        }, contentDescription = null
                                    )
                                }
                            }, label = {
                                Text(
                                    modifier = Modifier.rotate(180f),
                                    text = it.itemName,
                                    style = MaterialTheme.typography.bodySmall,
                                    maxLines = 1
                                )
                            })
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }

            NavHost(
                navController = navController,
                startDestination = ExploreNavigationRoutes.NEW_RELEASES.name
            ) {
                composable(route = ExploreNavigationRoutes.NEW_RELEASES.name) {
                    NewReleasesScreen()
                }
                composable(route = ExploreNavigationRoutes.DISCOVER_ARTISTS.name) {
                    ArtistsScreen()
                }
                composable(route = ExploreNavigationRoutes.DISCOVER_TRACKS.name) {
                    TracksScreen()
                }
                composable(route = ExploreNavigationRoutes.LIBRARY.name) {

                }
                composable(route = ExploreNavigationRoutes.DISCOVER_PLAYLISTS.name) {
                    PlaylistsScreen()
                }
                composable(route = ExploreNavigationRoutes.DISCOVER_DHHT_ACCOUNTS.name) {
                    DHHTScreen()
                }
            }
        }
    }
}