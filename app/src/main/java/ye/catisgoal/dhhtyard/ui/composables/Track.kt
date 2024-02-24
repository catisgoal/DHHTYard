package ye.catisgoal.dhhtyard.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class TrackDTO(
    val trackCoverArtURL: String,
    val trackName: String,
    val trackArtists: List<String>,
    val trackSpotifyURL: String,
    val trackYTURL: String,
    val onMoreClick: () -> Unit = {},
    val onTrackClick: () -> Unit = {},
    val onBookmarkClick: () -> Unit = {},
    val isBookmarked: Boolean = false
)

@Composable
fun Track(
    trackDTO: TrackDTO
) {
    Row(
        modifier = Modifier
            .pulsateEffect(targetValue = 0.96f, onClick = {
                trackDTO.onTrackClick()
            })
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = trackDTO.trackCoverArtURL,
            contentDescription = "", modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.fillMaxWidth(0.50f)) {
            Text(
                text = trackDTO.trackName,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                trackDTO.trackArtists.forEach {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(0.75f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Row {
                Icon(
                    imageVector = if (trackDTO.isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkAdd,
                    contentDescription = "", modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            trackDTO.onBookmarkClick()
                        }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "jatin in da houz",
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            trackDTO.onMoreClick()
                        }
                )
            }
        }
    }
}