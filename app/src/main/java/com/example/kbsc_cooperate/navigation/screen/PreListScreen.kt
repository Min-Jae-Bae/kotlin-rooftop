package com.example.kbsc_cooperate.navigation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PreListScreen(navController: NavController,onBackCLick: () -> Unit){
Column(){
    TopAppBar(
        modifier = Modifier.padding(bottom = 40.dp),
        elevation = 3.dp,
        backgroundColor = Color(0xFF8BB9FF),
        title = {
            Text(text = "예약 확인", color = Color.White, fontSize = 20.sp)
        },
        navigationIcon = {
            IconButton(onClick = onBackCLick) {
                Icon(Icons.Filled.ArrowBack,null, tint = Color.White)
            }
        },
    )
}

}

@Preview
@Composable
fun ListPreview(){
    PreListScreen(navController = rememberNavController(), onBackCLick = ({}))
}