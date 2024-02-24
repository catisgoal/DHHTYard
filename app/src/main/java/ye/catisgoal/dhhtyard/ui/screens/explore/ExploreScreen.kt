package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.Track
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO

@Composable
fun ExploreScreen(navController: NavController) {
    val exploreScreenVM: ExploreScreenVM = viewModel()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            NavigationRail(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                exploreScreenVM.railNavigationList.forEach {
                    androidx.compose.material3.NavigationRailItem(
                        modifier = Modifier.rotate(90f),
                        selected = currentRoute == it.navigationRoute.name,
                        onClick = {

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
            Column {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(sampleData.shuffled() + sampleData.shuffled()) {
                        Track(
                            trackDTO = TrackDTO(
                                trackCoverArtURL = it.trackCoverArtURL,
                                trackName = it.trackName,
                                trackArtists = it.trackArtists,
                                trackSpotifyURL = it.trackSpotifyURL,
                                trackYTURL = it.trackYTURL
                            )
                        )
                    }
                }
            }
        }
    }
}