package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberNew
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.outlined.FiberNew
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlaylistAdd
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import ye.catisgoal.dhhtyard.ExploreNavigationRoutes
import ye.catisgoal.dhhtyard.ExploreScreenType
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.ProjectDTO
import ye.catisgoal.dhhtyard.ui.composables.pulsateEffect
import ye.catisgoal.dhhtyard.ui.navigation.NavigationItemDTO
import ye.catisgoal.dhhtyard.ui.theme.DHHTYardTheme

class ExploreScreenVM : ViewModel() {
    val railNavigationList = listOf(
        NavigationItemDTO(
            selectedIcon = Icons.Filled.FiberNew,
            nonSelectedIcon = Icons.Outlined.FiberNew,
            navigationRoute = ExploreNavigationRoutes.NEW_RELEASES,
            itemName = "Releases"
        ),
        NavigationItemDTO(
            selectedIcon = Icons.Filled.Person,
            nonSelectedIcon = Icons.Outlined.Person,
            navigationRoute = ExploreNavigationRoutes.DISCOVER_ARTISTS,
            itemName = "Artists"
        ),
        NavigationItemDTO(
            selectedIcon = Icons.Filled.LibraryMusic,
            nonSelectedIcon = Icons.Outlined.LibraryMusic,
            navigationRoute = ExploreNavigationRoutes.LIBRARY,
            itemName = "Library"
        ),
        NavigationItemDTO(
            selectedIcon = Icons.Filled.PlaylistAdd,
            nonSelectedIcon = Icons.Outlined.PlaylistAdd,
            navigationRoute = ExploreNavigationRoutes.DISCOVER_PLAYLISTS,
            itemName = "Playlists"
        ),
        NavigationItemDTO(
            selectedIcon = Icons.Filled.People,
            nonSelectedIcon = Icons.Outlined.People,
            navigationRoute = ExploreNavigationRoutes.DISCOVER_DHHT_ACCOUNTS,
            itemName = "DHHT"
        ),
    )

    val parentLibraryScreenList: () -> List<ExploreScreenModal> = {
        listOf(
            ExploreScreenModal("Tracks", { TracksScreen() }, ExploreScreenType.TRACKS),
            ExploreScreenModal("EPs", {
                ProjectsList(list = sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }, scaffoldPaddingValues = PaddingValues(0.dp))
            }, ExploreScreenType.EPS),
            ExploreScreenModal("Albums", {
                ProjectsList(list = sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }, scaffoldPaddingValues = PaddingValues(0.dp))
            }, ExploreScreenType.ALBUMS),
            ExploreScreenModal("LPs", {
                ProjectsList(list = sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }, scaffoldPaddingValues = PaddingValues(0.dp))
            }, ExploreScreenType.LPS),
            ExploreScreenModal("Mix-tapes", {
                ProjectsList(list = sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }, scaffoldPaddingValues = PaddingValues(0.dp))
            }, ExploreScreenType.MIXTAPES),
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    val parentDHHTScreenList: () -> List<ExploreScreenModal> = {
        listOf(
            ExploreScreenModal("Releases", {
                ProjectsList(list = sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }, scaffoldPaddingValues = PaddingValues(0.dp))
            }, ExploreScreenType.EPS),
            ExploreScreenModal("Accounts", {
                DHHTYardTheme {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(sampleData + sampleData) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .pulsateEffect(targetValue = 0.9f, onClick = {})
                            ) {
                                AsyncImage(
                                    model = it.trackCoverArtURL,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clip(
                                            CircleShape
                                        )
                                        .size(75.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = it.trackArtists[0],
                                    style = MaterialTheme.typography.titleMedium,
                                    modifier = Modifier
                                        .padding(end = 15.dp)
                                        .basicMarquee(),
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }, ExploreScreenType.EPS),
        )
    }
}

data class ExploreScreenModal(
    val name: String,
    val screen: @Composable () -> Unit,
    val exploreScreenType: ExploreScreenType
)