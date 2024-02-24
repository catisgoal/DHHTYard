package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.Track
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TracksScreen() {
    Column {
        Spacer(modifier = Modifier.height(10.dp))
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