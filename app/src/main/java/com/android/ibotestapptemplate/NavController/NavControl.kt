package com.android.ibotestapptemplate.NavController

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.compose.rememberAsyncImagePainter

@Composable
fun NavControl(navController: NavHostController){
    NavHost(navController, startDestination = "grid") {
        composable("grid") { MovieGridScreen(navController) }
        composable(
            "detail/{title}/{image}/{synopsis}"

        )
        composable(
            arguments = listOf(navArgument("title") { type = NavType.StringType },
            navArgument("image") { type = NavType.StringType },
            navArgument("synopsis") { type = NavType.StringType }

        )
        )

        { backStackEntry ->
            MovieDetailScreen(
                title = backStackEntry.arguments?.getString("title") ?: "",
                image = backStackEntry.arguments?.getString("image") ?: "",
                synopsis = backStackEntry.arguments?.getString("synopsis") ?: ""
            )
        }
    }

}

@Composable
fun MovieDetailScreen(title: String, image: String, synopsis: String) {

}

@Composable
fun MovieGridScreen(navController: NavHostController, ) {

    val movies by viewModel.movies.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies) { movie ->
            Image(
                painter = rememberAsyncImagePainter(movie.image),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(4.dp)
                    .size(120.dp)
                    .clickable {
                        navController.navigate("detail/${movie.title}/${movie.image}/${movie.description}")
                    }
            )
        }
    }
}

}
