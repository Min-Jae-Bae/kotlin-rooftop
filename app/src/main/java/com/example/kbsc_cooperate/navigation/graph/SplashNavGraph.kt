package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kbsc_cooperate.R
import kotlinx.coroutines.delay


fun  NavGraphBuilder.splashNavGraph(navController: NavHostController) {
   navigation(
        route = Graph.SPLASH,
        startDestination = SplashScreen.Screen.route
    ) {
        composable(SplashScreen.Screen.route){
            Splash(navController = navController)
        }
        composable(Graph.AUTHENTICATION){
        }
    }

}

@Composable
fun Splash(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(3000L)
        navController.navigate(Graph.AUTHENTICATION)
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
        modifier = Modifier.fillMaxSize())
    }
    
}

sealed class SplashScreen(val route: String) {
    object Screen : SplashScreen ("Splash_Screen")
}

@Preview
@Composable
fun LandingScreenPreview(){
    Splash(navController = rememberNavController())
}

