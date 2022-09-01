package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kbsc_cooperate.home.ReservationScreen
import com.example.kbsc_cooperate.navigation.screen.InformationScreen

fun NavGraphBuilder.informationNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.INFORMATION,
        startDestination = InformationScreen.Information.route
    ) {
        composable(InformationScreen.Information.route){

        }
    }
}
sealed class InformationScreen(val route: String) {
    object Information : InformationScreen ("Information_Screen")
}
