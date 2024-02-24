package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.FiberNew
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.FiberNew
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlaylistAdd
import androidx.lifecycle.ViewModel
import ye.catisgoal.dhhtyard.ExploreNavigationRoutes
import ye.catisgoal.dhhtyard.ui.navigation.NavigationItemDTO

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
            selectedIcon = Icons.Filled.Audiotrack,
            nonSelectedIcon = Icons.Outlined.Audiotrack,
            navigationRoute = ExploreNavigationRoutes.DISCOVER_TRACKS,
            itemName = "Tracks"
        ),
        NavigationItemDTO(
            selectedIcon = Icons.Filled.Album,
            nonSelectedIcon = Icons.Outlined.Album,
            navigationRoute = ExploreNavigationRoutes.DISCOVER_ALBUMS,
            itemName = "Albums"
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
}