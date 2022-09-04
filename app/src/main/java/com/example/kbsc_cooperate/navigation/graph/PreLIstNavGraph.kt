package com.example.kbsc_cooperate.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kbsc_cooperate.navigation.screen.PreListScreen

fun NavGraphBuilder.preListNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PRE_LIST,
        startDestination = PreListScreen.PreList.route
    ) {
        composable(PreListScreen.PreList.route){
           PreListScreen(navController = navController) {
           }
        }
    }
}

sealed class PreListScreen(val route: String) {
    object PreList : PreListScreen("PreList_Screen")
}

