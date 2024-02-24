package ye.catisgoal.dhhtyard.ui.screens.explore

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ye.catisgoal.dhhtyard.sampleData
import ye.catisgoal.dhhtyard.ui.composables.pulsateEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistsScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {}, actions = {
            Text(
                text = "Playlists",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 26.sp,
                modifier = Modifier.padding(end = 10.dp)
            )
        })
    }) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(sampleData) {
                Column(modifier = Modifier
                    .pulsateEffect(targetValue = 0.9f, onClick = {})
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = it.trackName,
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .padding(end = 15.dp)
                                .align(Alignment.TopStart),
                            maxLines = 4,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Start,
                            overflow = TextOverflow.Ellipsis
                        )
                        AsyncImage(
                            model = it.trackCoverArtURL,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .align(Alignment.TopEnd), contentDescription = null
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 20.dp, end = 15.dp, start = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.trackArtists[0],
                            style = MaterialTheme.typography.titleSmall,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(end = 15.dp),
                            maxLines = 1,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Start,
                            overflow = TextOverflow.Ellipsis
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Outlined.ContentCopy,
                                contentDescription = null,
                                modifier = Modifier.clickable {

                                })
                            Icon(
                                imageVector = Icons.Outlined.BookmarkAdd,
                                contentDescription = null,
                                modifier = Modifier.clickable { })
                        }
                    }
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                        thickness = 0.5.dp,
                        color = MaterialTheme.colorScheme.outline.copy(0.25f)
                    )
                }
            }
        }
    }
}