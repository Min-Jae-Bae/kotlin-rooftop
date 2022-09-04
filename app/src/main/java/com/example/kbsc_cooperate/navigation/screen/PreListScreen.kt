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

@Composable
fun PreListScreen(navController: NavController,onBackCLick: () -> Unit) {
    Column() {
        TopAppBar(
            modifier = Modifier.padding(bottom = 40.dp),
            elevation = 3.dp,
            backgroundColor = Color(0xFF8BB9FF),
            title = {
                Text(text = "예약 확인", color = Color.White, fontSize = 20.sp)
            },
            navigationIcon = {
                IconButton(onClick = onBackCLick) {
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
                .height(170.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color(0xFF8BB9FF)),
            backgroundColor = Color.White,
            elevation = 10.dp
        )
        {
            Row(modifier = Modifier.padding(start = 40.dp, top = 20.dp)) {
                Column {
                    Text(
                        text = "날짜 ", color = Color(0xFF8BB9FF),
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "9월 13일", color = Color(0xFF8BB9FF),
                        fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "인원 수 ", color = Color(0xFF8BB9FF),
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "성인 : 2명", color = Color(0xFF8BB9FF),
                        fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Column() {
            Row( modifier = Modifier.padding(90.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Button( colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8BB9FF)),
                    onClick = {/*TODO*/}, modifier = Modifier
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

@Preview(showBackground = true)
@Composable
fun ListPreview(){
    PreListScreen(navController = rememberNavController(), onBackCLick = ({}))
}