package com.example.kbsc_cooperate.navigation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.navigation.graph.Graph
import com.example.kbsc_cooperate.navigation.graph.Screen

@Composable
fun PreListScreen(navController: NavController,count:String, count2:String,count3:String,count4:String) {
    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        TopAppBar(
            modifier = Modifier.padding(bottom = 40.dp),
            elevation = 3.dp,
            backgroundColor = Color(0xFF8BB9FF),
            title = {
                Text(text = "예약 확인", color = Color.White, fontSize = 20.sp)
            },
            navigationIcon = {
                IconButton(onClick ={navController.popBackStack()}) {
                    Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
                }
            },
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color(0xFF8BB9FF)),
            backgroundColor = Color.White,
            elevation = 10.dp
        )
        {
            Row(modifier = Modifier.padding(20.dp)) {
                Image(painter = painterResource(id = R.drawable.image01), contentDescription = "")
                Spacer(modifier = Modifier.padding(10.dp))
                Column {
                    Text(
                        text = "옥상 이름", color = Color(0xFF8BB9FF),
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color(0xFF8BB9FF)),
            backgroundColor = Color.White,
            elevation = 10.dp
        )
        {
            Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                Column {
                    Text(
                        text = "날짜 ", color = Color(0xFF8BB9FF),
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "9월 13일", color = Color(0xFF8BB9FF),
                        fontSize = 17.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(
                        text = "인원 수 ", color = Color(0xFF8BB9FF),
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(modifier = Modifier.padding(bottom = 2.dp),
                        text = if(count > 0.toString())"성인 :   $count " else "",
                        color = Color(0xFF8BB9FF),
                        fontSize = 17.sp, fontWeight = FontWeight.Bold
                    )
                    Text(modifier = Modifier.padding(bottom = 2.dp),
                        text = if(count2 > 0.toString())"어린이 :   $count2 " else "",
                        color = Color(0xFF8BB9FF),
                        fontSize = 17.sp, fontWeight = FontWeight.Bold
                    )
                    Text(modifier = Modifier.padding(bottom = 2.dp),
                        text = if(count3 > 0.toString())"유아 :   $count3 " else "",
                        color = Color(0xFF8BB9FF),
                        fontSize = 17.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if(count4 > 0.toString())"반려 동물 :   $count4 " else "",
                        color = Color(0xFF8BB9FF),
                        fontSize = 17.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Column() {
            Row( modifier = Modifier.padding(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Button( colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8BB9FF)),
                    onClick = {navController.navigate(Screen.Information.route)}, modifier = Modifier
                        .width(270.dp)
                        .height(50.dp)
                ) { Text(
                    "확인",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.background
                )
                }
            }
        }
    }
}
