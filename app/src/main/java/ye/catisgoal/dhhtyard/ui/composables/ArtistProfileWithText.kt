package ye.catisgoal.dhhtyard.ui.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ye.catisgoal.dhhtyard.ComposableOnClickState

data class ArtistProfileWithTextDTO(
    val artistPfpUrl: String,
    val artistName: String,
    val onClick: () -> Unit,
    val contentScale: ContentScale,
    val modifier: Modifier
)

@Composable
fun ArtistProfileWithTextComposable(
    artistProfileWithTextDTO: ArtistProfileWithTextDTO
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.pulsateEffect(
            targetValue = 0.9f,
            onClick = { artistProfileWithTextDTO.onClick() }
        )
    ) {
        AsyncImage(
            model = artistProfileWithTextDTO.artistPfpUrl,
            contentDescription = "gossip",
            modifier = Modifier
                .clip(CircleShape)
                .size(75.dp)
                .then(artistProfileWithTextDTO.modifier),
            contentScale = artistProfileWithTextDTO.contentScale
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = artistProfileWithTextDTO.artistName,
            fontSize = 14.sp,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

fun Modifier.pulsateEffect(onClick: () -> Unit, targetValue: Float) = composed {
    val composableState = remember {
        mutableStateOf(ComposableOnClickState.IDLE)
    }
    val scale = animateFloatAsState(
        targetValue = if (composableState.value == ComposableOnClickState.CLICKED) targetValue else 1f,
        label = ""
    )
    this
        .graphicsLayer {
            scaleX = scale.value
            scaleY = scale.value
        }
        .clickable(interactionSource = remember {
            MutableInteractionSource()
        }, indication = null, onClick = {
            onClick()
        })
        .pointerInput(composableState.value) {
            awaitPointerEventScope {
                composableState.value =
                    if (composableState.value == ComposableOnClickState.CLICKED) {
                        waitForUpOrCancellation()
                        ComposableOnClickState.IDLE
                    } else {
                        awaitFirstDown(false)
                        ComposableOnClickState.CLICKED
                    }
            }
        }
}