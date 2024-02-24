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

enum class NavigationRoutes {
    EXPLORE, SETTINGS, LIBRARY
}

data class BtmNavigationItem(
    val selectedIcon: ImageVector,
    val nonSelectedIcon: ImageVector,
    val navigationRoute: NavigationRoutes,
    val itemName: String,
)

class NavigationVM : ViewModel() {


    val btmBarList = listOf(
        BtmNavigationItem(
            itemName = "Explore",
            selectedIcon = Icons.Filled.Explore,
            nonSelectedIcon = Icons.Outlined.Explore,
            navigationRoute = NavigationRoutes.EXPLORE
        ),
        BtmNavigationItem(
            itemName = "Library",
            selectedIcon = Icons.Filled.LibraryMusic,
            nonSelectedIcon = Icons.Outlined.LibraryMusic,
            navigationRoute = NavigationRoutes.LIBRARY
        ),
        BtmNavigationItem(
            itemName = "Settings",
            selectedIcon = Icons.Filled.Settings,
            nonSelectedIcon = Icons.Outlined.Settings,
            navigationRoute = NavigationRoutes.SETTINGS
        ),
    )

    companion object {
        val startDestination =
            mutableStateOf(NavigationRoutes.EXPLORE.name)
    }

}