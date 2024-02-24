package ye.catisgoal.dhhtyard.ui.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import ye.catisgoal.dhhtyard.MainBtmNavigationRoutes


data class NavigationItemDTO(
    val selectedIcon: ImageVector,
    val nonSelectedIcon: ImageVector,
    val navigationRoute: Enum<*>,
    val itemName: String,
)

class NavigationVM : ViewModel() {


    val btmBarList = listOf(
        NavigationItemDTO(
            itemName = "Explore",
            selectedIcon = Icons.Filled.Explore,
            nonSelectedIcon = Icons.Outlined.Explore,
            navigationRoute = MainBtmNavigationRoutes.EXPLORE
        ),
        NavigationItemDTO(
            itemName = "Library",
            selectedIcon = Icons.Filled.LibraryMusic,
            nonSelectedIcon = Icons.Outlined.LibraryMusic,
            navigationRoute = MainBtmNavigationRoutes.LIBRARY
        ),
        NavigationItemDTO(
            itemName = "Settings",
            selectedIcon = Icons.Filled.Settings,
            nonSelectedIcon = Icons.Outlined.Settings,
            navigationRoute = MainBtmNavigationRoutes.SETTINGS
        ),
    )

    companion object {
        val startDestination =
            mutableStateOf(MainBtmNavigationRoutes.EXPLORE.name)
    }

}