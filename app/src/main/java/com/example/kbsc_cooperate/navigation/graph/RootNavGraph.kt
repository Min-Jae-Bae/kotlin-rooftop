package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.example.kbsc_cooperate.home.MainScreen

@ExperimentalPagingApi
@Composable
fun RootNavigationGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        splashNavGraph(navController = navController)
        authNavGraph(navController = navController)
        reservationGraph(navController = navController)
        composable(Graph.HOME) {
            MainScreen()
        }

    }
}


object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
    const val SEARCH = "search_graph"
    const val SPLASH = "landing_graph"
    const val RESERVATION = "reservation_graph"
    const val CALENDAR = "calender_graph"
}