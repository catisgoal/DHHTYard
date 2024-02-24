package ye.catisgoal.dhhtyard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ye.catisgoal.dhhtyard.R

val fonts = FontFamily(
    Font(R.font.semibold, weight = FontWeight.SemiBold),
    Font(R.font.bold, weight = FontWeight.Bold),
    Font(R.font.regular, weight = FontWeight.Normal)
)

val Typography = Typography(
    titleLarge = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Bold),
    titleMedium = TextStyle(fontFamily = fonts, fontWeight = FontWeight.SemiBold),
    titleSmall = TextStyle(fontFamily = fonts, fontWeight = FontWeight.Normal)
)