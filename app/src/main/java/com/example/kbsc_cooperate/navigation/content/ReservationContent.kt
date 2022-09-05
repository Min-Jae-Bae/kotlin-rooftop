package com.example.kbsc_cooperate.navigation.content

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.home.ReservationScreen
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

@Composable
fun ReservationContent(navController: NavController
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
                Text(
                    if (isExpanded) "" else "위치",
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
}

@Preview(showBackground = true)
@Composable
fun ReservationPreview(){
    KBSC_CooperateTheme {
        ReservationContent(navController = rememberNavController())
    }
}