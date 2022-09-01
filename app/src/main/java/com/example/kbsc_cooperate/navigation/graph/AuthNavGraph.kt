package com.example.kbsc_cooperate.navigation.graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.kbsc_cooperate.login.*
import com.example.kbsc_cooperate.login.LoginHome
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(AuthScreen.Login.route) {
            LoginHome(
                auth = Firebase.auth,
                onNavToHomePage = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onNavToSignUpPage = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )
        }
        composable(AuthScreen.SignUp.route) {
            SignUpScreen(
                auth = Firebase.auth,
                onNavToHomePage = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onNavToLoginPage = {
                    navController.navigate(AuthScreen.Login.route)
                }

            )
        }
        composable(AuthScreen.forgot.route) {
//            SignUpScreen(
//                auth = Firebase.auth,
//                onNavToHomePage = {
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
//                },
//                onNavToLoginPage = {
//                    navController.navigate(AuthScreen.Login.route)
//                }
//
//            )
        }
    }
}


sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("LOGIN")
    object SignUp : AuthScreen("SIGN_UP")
    object forgot : AuthScreen("forgot")
}

//enum class LoginRoutes{
//    Signup,
//    SignIn
//}
//
//enum class HomeRoutes{
//    Home,
//    Detail
//}
//
//@Composable
//fun authNavGraph(
//    navController: NavHostController = rememberNavController(),
//    loginViewModel: ViewModel
//){
//    NavHost(navController = navController,
//        startDestination = LoginRoutes.SignIn.name
//    ){
//        composable(route = LoginRoutes.SignIn.name){
//            LoginScreen(onNavToHomePage = {
//                navController.navigate(HomeRoutes.Home.name){
//                    launchSingleTop = true
//                    popUpTo(route = LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            }){
//                navController.navigate(LoginRoutes.Signup.name){
//                    launchSingleTop = true
//                    popUpTo(LoginRoutes.SignIn.name){
//                        inclusive = true
//                    }
//                }
//            }
//        }
//
//        composable(route = LoginRoutes.Signup.name){
//            SignUpScreen(Firebase.auth, onNavToHomePage = {
//                navController.navigate(HomeRoutes.Home.name){
//                    popUpTo(LoginRoutes.Signup.name){
//                        inclusive = true
//                    }
//                }
//            }) {
//                navController.navigate(LoginRoutes.SignIn.name)
//            }
//        }
//
//        composable(route = HomeRoutes.Home.name){
//            HomeNavGraph(navController = rememberNavController())
//        }
//    }
//}