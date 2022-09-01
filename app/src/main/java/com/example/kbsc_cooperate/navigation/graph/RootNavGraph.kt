package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        authNavGraph(navController = navController)
        splashNavGraph(navController = navController)
        calendarNavGraph(navController = navController)
        reservationNavGraph(navController = navController)
        composable(Graph.HOME) {

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
    const val CALENDAR = "calender_graph"
    const val INFORMATION = "information_screen"
    const val RESERVATION = "reservation_screen"

}