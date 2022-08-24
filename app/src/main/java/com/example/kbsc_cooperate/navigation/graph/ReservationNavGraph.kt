package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kbsc_cooperate.calendar.CalendarScreen
import com.example.kbsc_cooperate.home.MainViewModel
import com.example.kbsc_cooperate.home.ReservationScreen

fun NavGraphBuilder.reservationGraph(navController: NavHostController){
    navigation(
        route = Graph.RESERVATION,
        startDestination = ReservationScreen.Reservation.route
    ) {
        composable(ReservationScreen.Reservation.route){
            ReservationScreen(navController = navController)
        }
    }
}

sealed class ReservationScreen(val route: String) {
    object Reservation : ReservationScreen ("Reservation_Screen")
}

