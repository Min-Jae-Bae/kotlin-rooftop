package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.kbsc_cooperate.navigation.content.ListContent
import com.example.kbsc_cooperate.navigation.content.ScreenContent
import com.example.kbsc_cooperate.navigation.screen.BottomBarScreen
import kotlinx.serialization.json.JsonNull.content


@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            content = {}
            ListContent(items = getAllImages)
        /*            ScreenContent(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )*/
        }
        composable(BottomBarScreen.Like.route) {
            ScreenContent(
                name = BottomBarScreen.Like.route,
                onClick = { /*TODO: Next Navigate*/ }
                )
        }
        composable(BottomBarScreen.Profile.route) {
            ScreenContent(
                name = BottomBarScreen.Profile.route,
                onClick = { /*TODO: Next Navigate*/ }
            )
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(DetailsScreen.Information.route) {
            ScreenContent(name = DetailsScreen.Information.route) {
                navController.navigate(DetailsScreen.OverView.route)
            }
        }
        composable(DetailsScreen.OverView.route) {
            ScreenContent(name = DetailsScreen.OverView.route) {
                navController.popBackStack(
                    route = DetailsScreen.Information.route,
                    inclusive = false
                )
            }
        }
    }
}

sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object Search: Screen("search_screen")
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen("INFORMATION")
    object OverView : DetailsScreen("OVERVIEW")
}