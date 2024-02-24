package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.Track
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO

@Composable
fun NewReleasesScreen() {
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