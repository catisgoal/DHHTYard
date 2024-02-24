package ye.catisgoal.dhhtyard.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.ArtistProfileWithTextComposable
import ye.catisgoal.dhhtyard.ui.composables.ArtistProfileWithTextDTO
import ye.catisgoal.dhhtyard.ui.composables.Track
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(sampleData.shuffled()) {
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
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(sampleData) {
                    ArtistProfileWithTextComposable(
                        artistProfileWithTextDTO = ArtistProfileWithTextDTO(
                            artistPfpUrl = it.trackCoverArtURL,
                            artistName = it.trackArtists.random(),
                            onClick = { -> },
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                        )
                    )
                }
            }
        }
    }
}