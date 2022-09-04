package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kbsc_cooperate.navigation.screen.InformationScreen
import com.example.kbsc_cooperate.navigation.screen.PreListScreen

@Composable
fun InformationNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.INFORMATION,
        startDestination = InformationScreen.Information.route
    ) {
        composable(InformationScreen.Information.route){
            InformationScreen(navController = navController){
            }
        }
        composable(Graph.PRE_LIST){
            PreListScreen(navController = navController) {
            }
        }
    }
}

sealed class InformationScreen(val route: String) {
    object Information : InformationScreen("Information_Screen")
}
