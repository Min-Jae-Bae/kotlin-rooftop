package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.navigation.screen.ReservationScreen
import com.example.kbsc_cooperate.navigation.screen.InformationScreen
import com.example.kbsc_cooperate.navigation.screen.PreListScreen

fun NavGraphBuilder.screenNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SCREEN,
        startDestination = Screen.Reservation.route
    ) {
        composable(Screen.Reservation.route) {
            ReservationScreen(navController = navController)
        }
        composable(Screen.Information.route) {
            InformationScreen(navController = navController)
        }
        composable("Screen.PreList.route/{count}/{count2}/{count3}/{count4}") {
            backStackEntry ->
            PreListScreen(navController = navController,
                count= backStackEntry.arguments?.getString("count")?:"",
                count2 = backStackEntry.arguments?.getString("count2")?:"",
                count3 = backStackEntry.arguments?.getString("count3")?:"",
                count4 = backStackEntry.arguments?.getString("count4")?:"")
        }
    }
}
sealed class Screen(val route: String){
    object Reservation : Screen ("reservation_screen")
    object Information : Screen ("information_screen")
    object PreList : Screen ("pre_list_screen")
}

