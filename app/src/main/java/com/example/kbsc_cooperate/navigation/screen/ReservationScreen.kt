package com.example.kbsc_cooperate.home

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.base.ReservationIconButtons
import com.example.kbsc_cooperate.base.RoundIconButtons
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReservationScreen(navController: NavController
) {
    val scrollState = rememberScrollState()
    val count = remember { mutableStateOf(0) }
    val count2 = remember { mutableStateOf(0) }
    val count3 = remember { mutableStateOf(0) }
    val count4 = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(top = 100.dp)
            .verticalScroll(scrollState)
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
                Text(if (isExpanded) "" else "위치",fontWeight = FontWeight.Bold,color = MaterialTheme.colors.background)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                ) {}
            }
        }
        Column(modifier = Modifier.padding(top = 10.dp)) {
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
                    if (isExpanded) {
                        Column(modifier = Modifier.padding(top = 20.dp, bottom= 20.dp)) {
                            Text( "인원을 선택하세요", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 70.dp, bottom = 40.dp),
                                color = Color.White)
                            Row(
                                modifier = Modifier.padding(bottom = 20.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Spacer(modifier = Modifier.width(30.dp))
                                Text(
                                    "성인", modifier = Modifier.align(
                                        alignment = Alignment.CenterVertically
                                    ), color = Color.White
                                )
                                Spacer(modifier = Modifier.width(80.dp))
                                Row(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    /*val count = remember { mutableStateOf(0) }*/
                                    RoundIconButtons( // 감소 버튼
                                        imageVector = Icons.Default.Remove,
                                        onClick = { if (count.value > 1) count.value-- else count.value =0})
                                    Text(
                                        "${count.value}", modifier = Modifier
                                            .align(
                                                alignment = Alignment.CenterVertically
                                            )
                                            .padding(start = 10.dp, end = 10.dp), color = Color.White
                                    )
                                    RoundIconButtons( // 증가 버튼
                                        imageVector = Icons.Default.Add,
                                        onClick = { count.value++})
                                }
                            }
                            Row(
                                modifier = Modifier.padding(bottom = 20.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Spacer(modifier = Modifier.width(25.dp))
                                Text(
                                    "어린이", modifier = Modifier.align(
                                        alignment = Alignment.CenterVertically
                                    ), color = Color.White
                                )
                                Spacer(modifier = Modifier.width(70.dp))
                                Row(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    /*val count = remember { mutableStateOf(0) }*/
                                    RoundIconButtons( // 감소 버튼
                                        imageVector = Icons.Default.Remove,
                                        onClick = { if (count2.value > 1) count2.value-- else count2.value =0})
                                    Text(
                                        "${count2.value}", modifier = Modifier
                                            .align(
                                                alignment = Alignment.CenterVertically
                                            )
                                            .padding(start = 10.dp, end = 10.dp), color = Color.White
                                    )
                                    RoundIconButtons( // 증가 버튼
                                        imageVector = Icons.Default.Add,
                                        onClick = {count2.value++})
                                }
                            }
                            Row(
                                modifier = Modifier.padding(bottom = 20.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Spacer(modifier = Modifier.width(30.dp))
                                Text(
                                    "유아", modifier = Modifier.align(
                                        alignment = Alignment.CenterVertically
                                    ), color = Color.White
                                )
                                Spacer(modifier = Modifier.width(80.dp))
                                Row(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    /*val count = remember { mutableStateOf(0) }*/
                                    RoundIconButtons( // 감소 버튼
                                        imageVector = Icons.Default.Remove,
                                        onClick = {if (count3.value > 1) count3.value-- else count3.value =0})
                                    Text(
                                        "${count3.value}", modifier = Modifier
                                            .align(
                                                alignment = Alignment.CenterVertically
                                            )
                                            .padding(start = 10.dp, end = 10.dp), color = Color.White
                                    )
                                    RoundIconButtons( // 증가 버튼
                                        imageVector = Icons.Default.Add,
                                        onClick = { count3.value++})
                                }
                            }
                            Row(
                                modifier = Modifier.padding(bottom = 20.dp),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Spacer(modifier = Modifier.width(20.dp))
                                Text(
                                    "반려 동물", modifier = Modifier.align(
                                        alignment = Alignment.CenterVertically
                                    ), color = Color.White
                                )
                                Spacer(modifier = Modifier.width(57.5.dp))
                                Row(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    /*val count = remember { mutableStateOf(0) }*/
                                    RoundIconButtons( // 감소 버튼
                                        imageVector = Icons.Default.Remove,
                                        onClick = { if (count4.value > 1) count4.value-- else count4.value =0})
                                    Text(
                                        "${count4.value}", modifier = Modifier
                                            .align(
                                                alignment = Alignment.CenterVertically
                                            )
                                            .padding(start = 10.dp, end = 10.dp), color = Color.White
                                    )
                                    RoundIconButtons( // 증가 버튼
                                        imageVector = Icons.Default.Add,
                                        onClick = { count4.value++})
                                }
                            }
                            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                                ) {
                                Button(onClick = { isExpanded = !isExpanded },
                                modifier = Modifier.width(200.dp), content={Text(color = MaterialTheme.colors.onSecondary, text = "확인"
                                    )})
                            }
                        }
                    } //isExpandable
                    Spacer(Modifier.width(95.dp))
                    Icon(
                        Icons.Filled.Person, contentDescription = "person",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(if(isExpanded)"" else "인원 수"
                        ,fontWeight = FontWeight.Bold,color = MaterialTheme.colors.background)
                    Column(
                         modifier = Modifier
                             .weight(1f)
                             .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                     ) {}
            } //인원 수 row end
        }
        Column(modifier = Modifier.padding(top = 10.dp)) {
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
                        .clickable { }
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Spacer(Modifier.width(98.dp))
                    Icon(
                        Icons.Filled.CalendarToday, contentDescription = "date",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "날짜",
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.background
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                    ) {
                    }
                }
            }
            Column(modifier = Modifier.padding(top = 10.dp)) {
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
                            if (isExpanded) "" else "테마",
                            fontWeight = FontWeight.Bold,
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
            Column(modifier = Modifier.padding(top = 80.dp)) { //예약 하기
                Surface(
                    color = Color(0xFF979797),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp, horizontal = 50.dp),
                    shape = RoundedCornerShape(50.dp),
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround) {
                        Spacer(Modifier.width(70.dp))
                        Text(
                            "예약 하기",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.background
                        )
                        Spacer(Modifier.width(60.dp))
                       ReservationIconButtons(
                            imageVector = Icons.Default.East,
                            onClick = { })
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {}
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
        ReservationScreen(navController = rememberNavController())
    }
}

