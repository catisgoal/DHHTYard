package ye.catisgoal.dhhtyard.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ProjectDTO(
    val projectType: String,
    val projectTitle: String,
    val projectArtists: String,
    val projectCoverArtURL: String,
    val projectYTLink: String,
    val projectSpotifyLink: String,
    val onClick: () -> Unit = {}
)

@Composable
fun Project(
    projectDTO: ProjectDTO
) {
    val size = remember {
        mutableStateOf(128.dp)
    }
    Column(modifier = Modifier.pulsateEffect(targetValue = 0.9f, onClick = {
        projectDTO.onClick()
    })) {
        AsyncImage(
            model = projectDTO.projectCoverArtURL,
            contentDescription = "",
            modifier = Modifier
                .size(size.value)
                .clip(RoundedCornerShape(15.dp))
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(160.dp)
        ) {
            Text(
                text = projectDTO.projectType,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = projectDTO.projectTitle,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(size.value)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = projectDTO.projectArtists,
            style = MaterialTheme.typography.titleSmall,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(size.value)
        )
    }
}