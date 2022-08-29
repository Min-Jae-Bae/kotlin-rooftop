package com.example.kbsc_cooperate.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PreListScreen(navController: NavController){


}

@Preview
@Composable
fun ListPreview(){
    PreListScreen(navController = rememberNavController())
}