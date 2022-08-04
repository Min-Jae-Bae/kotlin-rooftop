package com.example.kbsc_cooperate.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReservationScreen(
) {
    Column(
        modifier = Modifier
            .padding(top = 70.dp)
    ) { // 위 공백
        Surface(
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 50.dp),
            border = BorderStroke(1.dp, color = MaterialTheme.colors.onSecondary),
            shape = RoundedCornerShape(15.dp)
        ) {
            var isExpanded by remember { mutableStateOf(false) }
            val extraPadding by animateDpAsState(
                if (isExpanded) 300.dp else 0.dp,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            Row( //위치
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround) {
                Spacer(Modifier.width(98.dp))
                Icon(
                    Icons.Filled.Place, contentDescription = "place",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    if (isExpanded) "" else "위치", fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.background
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                ) {}
            }
        }
        Column() {
            Surface(
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 50.dp),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.onSecondary),
                shape = RoundedCornerShape(15.dp),
            ) {
                var isExpanded by remember { mutableStateOf(false) }
                val extraPadding by animateDpAsState(
                    if (isExpanded) 300.dp else 0.dp,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                Row( //인원 수
                    modifier = Modifier
                        .clickable { isExpanded = !isExpanded }
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Spacer(Modifier.width(95.dp))
                    Icon(
                        Icons.Filled.Person, contentDescription = "person",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        if (isExpanded) "" else "인원 수", fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background
                    )
                    Column(
                         modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                     ) {}
            } //인원 수 row end
        }
        Column() {
            Surface(
                color = MaterialTheme.colors.onSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 50.dp),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.onSecondary),
                shape = RoundedCornerShape(15.dp),
            ) {
                var isExpanded by remember { mutableStateOf(false) }
                val extraPadding by animateDpAsState(
                    if (isExpanded) 300.dp else 0.dp,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                Row( //날짜
                    modifier = Modifier
                        .clickable { isExpanded = !isExpanded }
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Spacer(Modifier.width(98.dp))
                    Icon(
                        Icons.Filled.CalendarToday, contentDescription = "date",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        if (isExpanded) "" else "날짜", fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.background
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                    ) {
                    }
                }
            }
            Column() {
                Surface(
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 50.dp),
                    border = BorderStroke(1.dp, color = MaterialTheme.colors.onSecondary),
                    shape = RoundedCornerShape(15.dp),
                ) {
                    var isExpanded by remember { mutableStateOf(false) }
                    val extraPadding by animateDpAsState(
                        if (isExpanded) 300.dp else 0.dp,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    Row( //테마
                        modifier = Modifier
                            .clickable { isExpanded = !isExpanded }
                            .padding(15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Spacer(Modifier.width(98.dp))
                        Icon(
                            Icons.Filled.Check, contentDescription = "theme",
                            modifier = Modifier.size(ButtonDefaults.IconSize),
                            tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            if (isExpanded) "" else "테마", fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.background
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                        ) {}
                        }
                    }
                }
            Column(){
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .width(294.dp)
                            .height(400.dp)
                            .border(1.dp, Color.Black),
                        /* contentAlignment = Alignment.Center*/
                    ) {
                        Column() {
                            Row( // 이미지,장소
                                modifier = Modifier.padding(all = 50.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.image01),
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .border(1.5.dp, Color.Black, CircleShape)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "서울, 홍대",
                                        modifier = Modifier.padding(vertical = 25.dp)
                                    )
                                }
                            }
                            Row( // 이미지,장소
                                modifier = Modifier.padding(all = 50.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.image01),
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .border(1.5.dp, Color.Black, CircleShape)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "서울, 홍대",
                                        modifier = Modifier.padding(vertical = 25.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ButtonPreview(){
    KBSC_CooperateTheme {
        ReservationScreen()
    }
}

