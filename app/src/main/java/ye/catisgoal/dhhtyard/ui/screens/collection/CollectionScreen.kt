package ye.catisgoal.dhhtyard.ui.screens.collection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.ProjectDTO
import ye.catisgoal.dhhtyard.ui.composables.pulsateEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionScreen() {
    val searchBarQuery = rememberSaveable {
        mutableStateOf("")
    }
    val isSearchBarActive = rememberSaveable {
        mutableStateOf(false)
    }
    Column {
        SearchBar(
            query = searchBarQuery.value,
            onQueryChange = { searchBarQuery.value = it },
            onSearch = {},
            active = isSearchBarActive.value,
            onActiveChange = {
                isSearchBarActive.value = it
            },
            modifier = if (isSearchBarActive.value) Modifier.fillMaxWidth() else Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {

        }
        Text(
            text = "Saved",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(15.dp),
            fontSize = 20.sp
        )
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(sampleData.map {
                    ProjectDTO(
                        projectType = listOf("EP", "LP", "Album", "Mix-tape").random(),
                        projectTitle = it.trackName,
                        projectArtists = it.trackArtists[0],
                        projectCoverArtURL = it.trackCoverArtURL,
                        projectYTLink = it.trackYTURL,
                        projectSpotifyLink = it.trackSpotifyURL,
                        onClick = { -> })
                }) {
                    Column(modifier = Modifier.pulsateEffect(targetValue = 0.9f, onClick = {
                    })) {
                        AsyncImage(
                            model = it.projectCoverArtURL,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .clip(RoundedCornerShape(15.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp)
                        ) {
                            Text(
                                text = it.projectType,
                                style = MaterialTheme.typography.titleMedium,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Icon(imageVector = Icons.Outlined.BookmarkAdd,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .clickable {

                                    })
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = it.projectTitle,
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = it.projectArtists,
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp)
                        )
                    }
                }
            }
        }
    }
}