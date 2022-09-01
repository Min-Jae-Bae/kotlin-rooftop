package com.example.kbsc_cooperate.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kbsc_cooperate.calendar.Calendar
import com.example.kbsc_cooperate.calendar.model.CalendarState

fun NavGraphBuilder.calendarNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CALENDAR,
        startDestination = CalendarScreen.Calendar.route
    ) {
        composable(CalendarScreen.Calendar.route){
            Calendar(CalendarState(), onDayClicked = { })
        }
    }
}

sealed class CalendarScreen(val route: String) {
    object Calendar : CalendarScreen ("Calendar_Screen")
}