package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.Track
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TracksScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, actions = {
            Text(
                text = "Tracks",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 10.dp)
            )
        })
    }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp), modifier = Modifier.padding(it)
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