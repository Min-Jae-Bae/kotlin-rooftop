package com.example.kbsc_cooperate.base

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.R
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import org.w3c.dom.Text


val IconButtonSizeModifier = Modifier.size(30.dp)
@Composable
fun RoundIconButtons(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit,
    tint: Color = MaterialTheme.colors.onSecondary,
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp, ){
    Card(modifier = modifier.padding(all=4.dp).clickable{
        onClick.invoke()}.then(IconButtonSizeModifier),
        shape = CircleShape,
        backgroundColor = backgroundColor,
        elevation = elevation){
            Icon(imageVector, contentDescription = "Plus or Minus icon", tint = tint)
    }
}


