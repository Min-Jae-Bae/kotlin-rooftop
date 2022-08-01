package com.example.kbsc_cooperate.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import kotlin.math.round

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KBSC_CooperateTheme {

            }
        }
    }
}

@Composable
fun ButtonMain() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val extraPadding = if (isExpanded) 300.dp else 0.dp
    Column(
        modifier = Modifier.padding(vertical = 150.dp, horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .border(if(isExpanded)1.dp else 0.dp,
                    if(isExpanded)MaterialTheme.colors.onSecondary else MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp))
                .background(color = Color.White),
            border = BorderStroke(color = Color.White, width = Dp.Hairline),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding)
                    .width(300.dp)
                    .height(43.dp)
                    .background(if(isExpanded) MaterialTheme.colors.background else MaterialTheme.colors.onSecondary ),

                ) {
                Button(
                    //위치
                    onClick = {isExpanded = !isExpanded },
                    modifier = Modifier
                        .width(300.dp)
                        .height(43.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor =  if(isExpanded) MaterialTheme.colors.background else MaterialTheme.colors.onSecondary ,
                    )
                ) {
                    Icon(
                        Icons.Filled.Place,
                        contentDescription = "place",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        if(isExpanded)"" else "위치",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .background(color = Color.White)
                .border(if(isExpanded)1.dp else 0.dp,
                    if(isExpanded)MaterialTheme.colors.onSecondary else MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp))
                .background(color = Color.White),
            border = BorderStroke(color = Color.White, width = Dp.Hairline),
            shape = RoundedCornerShape(15.dp)

        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding)
                    .width(300.dp)
                    .height(43.dp)
                    .background(MaterialTheme.colors.onSecondary)
            ) {
                Button(
                    //인원 수
                    onClick = { isExpanded = !isExpanded},
                    modifier = Modifier
                        .width(300.dp)
                        .height(43.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary,
                    )
                ) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "person",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "인원 수",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .background(color = Color.White)
                .border(if(isExpanded)1.dp else 0.dp,
                    if(isExpanded)MaterialTheme.colors.onSecondary else MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp))
                .background(color = Color.White),
            border = BorderStroke(color = Color.White, width = Dp.Hairline),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding)
                    .width(300.dp)
                    .height(43.dp)
                    .background(MaterialTheme.colors.onSecondary)
            ) {
                Button(
                    //날짜
                    onClick = { isExpanded = !isExpanded },
                    modifier = Modifier
                        .width(300.dp)
                        .height(43.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary,
                    )
                ) {
                    Icon(
                        Icons.Filled.DateRange,
                        contentDescription = "date",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "날짜",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .background(color = Color.White)
                .border(if(isExpanded)1.dp else 0.dp,
                    if(isExpanded)MaterialTheme.colors.onSecondary else MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp))
                .background(color = Color.White),
            border = BorderStroke(color = Color.White, width = Dp.Hairline),
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = extraPadding)
                    .width(300.dp)
                    .height(43.dp)
                    .background(MaterialTheme.colors.onSecondary)
            ) {
                Button(
                    //테마
                    onClick = { isExpanded= !isExpanded },
                    modifier = Modifier
                        .width(300.dp)
                        .height(43.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSecondary,
                    )
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "theme",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "테마",
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
fun DefaultPreview() {
    KBSC_CooperateTheme {
        ButtonMain()
    }
}

