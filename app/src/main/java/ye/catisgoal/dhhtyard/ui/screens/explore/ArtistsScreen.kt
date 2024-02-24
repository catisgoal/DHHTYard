package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.ArtistProfileWithTextComposable
import ye.catisgoal.dhhtyard.ui.composables.ArtistProfileWithTextDTO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtistsScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, actions = {
            Text(
                text = "Artists",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 10.dp)
            )
        })
    }) {
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(sampleData + sampleData + sampleData + sampleData + sampleData + sampleData + sampleData + sampleData + sampleData + sampleData) {
                ArtistProfileWithTextComposable(
                    artistProfileWithTextDTO = ArtistProfileWithTextDTO(
                        artistPfpUrl = it.trackCoverArtURL,
                        artistName = it.trackName,
                        onClick = { -> },
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                )
            }
        }
    }
}