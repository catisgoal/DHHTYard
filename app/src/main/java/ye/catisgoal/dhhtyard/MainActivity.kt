package ye.catisgoal.dhhtyard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ye.catisgoal.dhhtyard.ui.composables.TrackDTO
import ye.catisgoal.dhhtyard.ui.navigation.BottomNavigationBar
import ye.catisgoal.dhhtyard.ui.navigation.MainNavigation
import ye.catisgoal.dhhtyard.ui.theme.DHHTYardTheme

val sampleData = listOf(
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1754170790831071232/WGAmDiUF_400x400.jpg",
        trackName = "sexa aloo",
        trackArtists = listOf("@hiayusharma"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1547540778800775169/DklEzzGd_400x400.jpg",
        trackName = "headphone",
        trackArtists = listOf("@imaheadphone, @mujhekyamaitoheadphonehu"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1740074467244773376/cv9P1L7c_400x400.jpg",
        trackName = "Tusha P \uD83D\uDDFF",
        trackArtists = listOf("@pushh_shh, @jcole_alt"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1730884039962435584/2xnEc-5l_400x400.jpg",
        trackName = "Robinsonthegoat",
        trackArtists = listOf("@robinsonthygoat, @robinsonthygoat"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1749759141697228800/dApPKcvV_400x400.jpg",
        trackName = "ND STAR",
        trackArtists = listOf("@BabyIamNdStar, Good Vibes OUT NOW!!!"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1761112630134222853/qeEgFh5A_400x400.jpg",
        trackName = "Katadah",
        trackArtists = listOf("@KTADA_X, @therealrapdemon_alt"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1747014617728172032/Sm-KYtY6_400x400.jpg",
        trackName = "Rachit",
        trackArtists = listOf("@imrachitalt, @imrachitp"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://pbs.twimg.com/profile_images/1733900112441823232/Ynv9PwUH_400x400.jpg",
        trackName = "DRW",
        trackArtists = listOf("@ankan_alt"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DHHTYardTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setNavigationBarColor(
                    colorScheme.surfaceColorAtElevation(
                        NavigationBarDefaults.Elevation
                    )
                )
                systemUiController.setStatusBarColor(MaterialTheme.colorScheme.background)
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    BottomNavigationBar(navController = navController)
                }) {
                    MainNavigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DHHTYardTheme {
        Greeting("Android")
    }
}