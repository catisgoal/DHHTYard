package ye.catisgoal.dhhtyard.ui.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import ye.catisgoal.dhhtyard.R
import kotlin.math.roundToInt

@Composable
fun SettingsScreen() {
    val cardOffSetX = remember { mutableStateOf(0f) }
    val cardOffSetY = remember { mutableStateOf(0f) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .offset {
                IntOffset(
                    cardOffSetX.value.roundToInt(),
                    cardOffSetY.value.roundToInt()
                )
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    cardOffSetX.value += dragAmount.x
                    cardOffSetY.value += dragAmount.y
                }
            }) {
            Text(text = "Movable")
            Image(painter = painterResource(id = R.drawable.a), contentDescription = "")
        }
    }
}