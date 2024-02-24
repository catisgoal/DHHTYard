package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import ye.catisgoal.dhhtyard.ui.composables.ProjectDTO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewReleasesScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, actions = {
            Text(
                text = "New Releases",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 10.dp)
            )
        })
    }) {
        ProjectsList(list = sampleData.map {
            ProjectDTO(
                projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                projectTitle = it.trackName,
                projectArtists = it.trackArtists[0],
                projectCoverArtURL = it.trackCoverArtURL,
                projectYTLink = it.trackYTURL,
                projectSpotifyLink = it.trackSpotifyURL,
                onClick = { -> })
        }, scaffoldPaddingValues = it)
    }
}