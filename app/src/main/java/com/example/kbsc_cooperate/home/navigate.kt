package com.example.kbsc_cooperate.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.login.LoginScreen
import com.example.kbsc_cooperate.login.SignUpScreen
import com.example.kbsc_cooperate.login.ViewModel

enum class LoginRoutes{
    Signup,
    SignIn
}
enum class HomeRoutes{
    Home,
    Detail
}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: ViewModel
){
    NavHost(navController = navController,
        startDestination = LoginRoutes.SignIn.name)
    {
        composable(route = LoginRoutes.SignIn.name){
            LoginScreen(onNavToHomePate = {
                navController.navigate(HomeRoutes.Home.name){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            },
                ViewModel = loginViewModel
            ){
                navController.navigate(LoginRoutes.Signup.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name){
            SignUpScreen(onNavToHomePate = {
                navController.navigate(HomeRoutes.Home.name) {
                    popUpTo(LoginRoutes.Signup.name) {
                        inclusive = true
                    }
                }
            },
                ViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)
                
            }
        }

        composable(route = HomeRoutes.Home.name){
            Home()
        }
    }
}