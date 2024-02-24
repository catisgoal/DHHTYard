package ye.catisgoal.dhhtyard.ui.screens.explore.library

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ye.catisgoal.dhhtyard.ui.screens.explore.ExploreScreenVM

@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalPagerApi::class
)
@Composable
fun ParentLibraryScreen() {
    val pagerState = rememberPagerState()
    val exploreScreenVM: ExploreScreenVM = viewModel()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, actions = {
            Text(
                text = "Library",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 10.dp)
            )
        })
    }) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
            ) {
                stickyHeader {
                    Column {
                        ScrollableTabRow(divider = {}, selectedTabIndex = pagerState.currentPage) {
                            exploreScreenVM.parentLibraryScreenList()
                                .forEachIndexed { index, exploreScreenModal ->
                                    Tab(selected = pagerState.currentPage == index, onClick = {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }.start()
                                    }) {
                                        Text(
                                            text = exploreScreenModal.name,
                                            style = MaterialTheme.typography.titleLarge,
                                            fontSize = 18.sp,
                                            modifier = Modifier.padding(15.dp),
                                            color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                                                0.70f
                                            )
                                        )
                                    }
                                }
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp
                        )
                    }
                }
            }
            HorizontalPager(
                count = exploreScreenVM.parentLibraryScreenList().size,
                state = pagerState
            ) {
                exploreScreenVM.parentLibraryScreenList()[it].screen()
            }
        }
    }
}