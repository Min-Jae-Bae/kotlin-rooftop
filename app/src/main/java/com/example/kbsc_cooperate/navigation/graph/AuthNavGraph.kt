package com.example.kbsc_cooperate.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.kbsc_cooperate.navigation.content.LoginContent
import com.example.kbsc_cooperate.navigation.content.ScreenContent

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(AuthScreen.Login.route) {
            LoginContent(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
        }
        composable(AuthScreen.SignUp.route) {
            ScreenContent(name = AuthScreen.SignUp.route) { }
        }
        composable(AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) { }
        }
    }

}


sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("LOGIN")
    object SignUp : AuthScreen("SIGN_UP")
    object Forgot : AuthScreen("FORGOT")
}