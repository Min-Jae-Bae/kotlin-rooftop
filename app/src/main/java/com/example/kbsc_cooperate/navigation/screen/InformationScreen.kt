package com.example.kbsc_cooperate.navigation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.R


@Composable
fun InformationScreen(navController: NavController) {
    Column(modifier = Modifier.background(color=Color.White)) {
        Column(
            modifier = Modifier
                .padding(top = 50.dp)
                .background(color = Color.White)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_account_circle),
                contentDescription = "Account Logo",
                modifier = Modifier.size(150.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 70.dp, bottom = 40.dp)
                    .height(50.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("이름", fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .height(50.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("예약 목록", fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .height(50.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("이메일", fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .height(50.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("핸드폰 번호", fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
        }
    }
}

@Preview
@Composable
fun InformationPreview(){
    InformationScreen(navController = rememberNavController())
}