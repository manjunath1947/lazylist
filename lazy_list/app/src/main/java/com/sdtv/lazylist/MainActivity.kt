package com.sdtv.lazylist

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sdtv.lazylist.ui.theme.LazyListTheme

class MainActivity : ComponentActivity() {

    companion object {
        val items : List<com.sdtv.lazylist.Item> = listOf(
            Item(title = "item 1",
                image = R.drawable.india),
            Item(title = "item 2",
                image = R.drawable.india),
            Item(title = "item 3",
                image = R.drawable.india),
            Item(title = "item 4",
                image = R.drawable.india),
            Item(title = "item 5",
                image = R.drawable.india),
            Item(title = "item 6",
                image = R.drawable.india),
            Item(title = "item 7",
                image = R.drawable.india),
            Item(title = "item 8",
                image = R.drawable.india),
            Item(title = "item 9",
                image = R.drawable.india),
            Item(title = "item 10",
                image = R.drawable.india)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    val navHostController = rememberNavController()
                    NavHost(navController = navHostController, startDestination = "home_screen" ) {
                        composable("home_screen") {
                            HomeScreen(navHostController = navHostController)
                        }
                        composable("lazy_row_screen") {
                            LazyRowScreen()
                        }
                        composable("lazy_column_screen") {
                            LazyColumnScreen()
                        }
                        composable("lazy_grid_screen") {
                            LazyGridScreen()
                        }
                    }
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
    LazyListTheme {
        Greeting("Android")
    }
}

@Composable
fun HomeScreen(
    navHostController : NavController
) {
Column(
modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Button(onClick = { navHostController.navigate("lazy_row_screen") }) {
        Text(text = "Lazy Row")
    }
    Spacer(modifier = Modifier.height(30.dp))

    Button(onClick = { navHostController.navigate("lazy_column_screen") }) {
        Text(text = "Lazy Column")
    }
    Spacer(modifier = Modifier.height(30.dp))

    Button(onClick = { navHostController.navigate("lazy_grid_screen") }) {
        Text(text = "Lazy Grid")
    }
}
    
}