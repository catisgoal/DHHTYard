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
        trackCoverArtURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Kanye_West_at_the_2009_Tribeca_Film_Festival_%28crop_2%29.jpg/640px-Kanye_West_at_the_2009_Tribeca_Film_Festival_%28crop_2%29.jpg",
        trackName = "Kanye West",
        trackArtists = listOf("@kanyewest"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://www.investopedia.com/thmb/t9ptoLnvjFl1qlVWhXIrnL17LGA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1205198865-48d9cf94a766422796067c893ef272e8.jpg",
        trackName = "Ye",
        trackArtists = listOf("@kanyewest, @ye"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://media.newyorker.com/photos/5909741d2179605b11ad8004/master/pass/Trammell-Kanye-West-Madison-Square-Garden.jpg",
        trackName = "Mr. West",
        trackArtists = listOf("@yzy, @ye"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://imgix.bustle.com/wmag/2016/09/06/57cf1630449b3b0baf16dcb4_1316.w.MS_.royals.image3_.jpg?w=414&h=499&fit=crop&crop=faces&auto=format%2Ccompress",
        trackName = "G.O.A.T",
        trackArtists = listOf("@kanyewest, @yeezy"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://i.pinimg.com/1200x/87/43/a1/8743a10b2b1958f8541af429ecf7e03e.jpg",
        trackName = "GROWN ASS SUPERHERO",
        trackArtists = listOf("VULTURES OUT NOW!!!"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://i.pinimg.com/474x/ac/39/08/ac3908c876870f5cc899c277218b7838.jpg",
        trackName = "HUH",
        trackArtists = listOf("@kanyewest, @yeezy"),
        trackSpotifyURL = "",
        trackYTURL = ""
    ),
    TrackDTO(
        trackCoverArtURL = "https://i.pinimg.com/736x/40/0b/25/400b25fae2bd5df08405140e2c115ec9.jpg",
        trackName = "YZYZYZYZY",
        trackArtists = listOf("@kanyewest, @yeezy"),
        trackSpotifyURL = "",
        trackYTURL = ""
    )
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