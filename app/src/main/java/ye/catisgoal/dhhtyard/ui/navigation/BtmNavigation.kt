package ye.catisgoal.dhhtyard.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomNavigationBar(navController: NavController) {
    val navigationVM: NavigationVM = viewModel()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        navigationVM.btmBarList.forEach {
            NavigationBarItem(
                selected = currentRoute == it.navigationRoute.name, onClick = {
                    if (currentRoute != it.navigationRoute.name) navController.navigate(it.navigationRoute.name)
                }, icon = {
                    Icon(
                        imageVector = if (currentRoute == it.navigationRoute.name) {
                            it.selectedIcon
                        } else {
                            it.nonSelectedIcon
                        }, contentDescription = null
                    )
                }, label = {
                    Text(
                        text = it.itemName,
                        style = MaterialTheme.typography.titleSmall,
                        maxLines = 1
                    )
                })
        }
    }
}