package com.example.kbsc_cooperate.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kbsc_cooperate.home.ReservationScreen

fun NavGraphBuilder.reservationNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.RESERVATION,
        startDestination = ReservationScreen.Reservation.route
    ) {
        composable( ReservationScreen.Reservation.route){
            ReservationScreen(navController = navController)
        }
    }
}

sealed class ReservationScreen(val route: String) {
    object Reservation : ReservationScreen ("Reservation_Screen")
}
