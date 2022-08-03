package com.example.kbsc_cooperate.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Place(  // 위치
) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 300.dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = if ( isExpanded) Color.White else MaterialTheme.colors.onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 50.dp),
        border = BorderStroke(1.dp,color = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Spacer(Modifier.width(98.dp))
                Icon(
                    Icons.Filled.Place, contentDescription = "place",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.White
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
                ) {
                }
            }
        }
    }
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Person( // 인원 수
) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 300.dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = if ( isExpanded) Color.White else MaterialTheme.colors.onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 170.dp, horizontal = 50.dp),
        border = BorderStroke(1.dp,color = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
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
                tint = Color.White
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
            ) {
            }
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Date( // 날짜
) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 300.dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = if ( isExpanded) Color.White else MaterialTheme.colors.onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 240.dp, horizontal = 50.dp),
        border = BorderStroke(1.dp,color = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(Modifier.width(98.dp))
            Icon(
                Icons.Filled.CalendarToday, contentDescription = "date",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
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
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Theme( //테마
) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 300.dp else 0.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = if ( isExpanded) Color.White else MaterialTheme.colors.onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 310.dp, horizontal = 50.dp),
        border = BorderStroke(1.dp,color = if (isExpanded) MaterialTheme.colors.onSecondary else Color.White),
        shape = RoundedCornerShape(15.dp),
    ) {
        Row(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Spacer(Modifier.width(98.dp))
            Icon(
                Icons.Filled.Check, contentDescription = "theme",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color.White
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
            ) {
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ButtonPreview(){
    KBSC_CooperateTheme {
        Place()
        Person()
        Date()
        Theme()
    }
}

