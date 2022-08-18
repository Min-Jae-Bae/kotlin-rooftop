package com.example.kbsc_cooperate.home

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
import com.example.kbsc_cooperate.base.RoundIconButtons
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReservationScreen(
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(top = 70.dp)
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
                                    val count = remember { mutableStateOf(0) }
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
                                    val count = remember { mutableStateOf(0) }
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
                                        onClick = {count.value++})
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
                                    val count = remember { mutableStateOf(0) }
                                    RoundIconButtons( // 감소 버튼
                                        imageVector = Icons.Default.Remove,
                                        onClick = {if (count.value > 1) count.value-- else count.value =0})
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
                                    val count = remember { mutableStateOf(0) }
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
                        }
                    }
                    Spacer(Modifier.width(95.dp))
                    Icon(
                        Icons.Filled.Person, contentDescription = "person",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(if (isExpanded) "" else "인원 수",fontWeight = FontWeight.Bold,color = MaterialTheme.colors.background)
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
                        if (isExpanded) "" else "날짜",fontWeight = FontWeight.Bold,color = MaterialTheme.colors.background)
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
                            if (isExpanded) "" else "테마",fontWeight = FontWeight.Bold,color = MaterialTheme.colors.background)
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
                            .padding(top = 20.dp)
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

