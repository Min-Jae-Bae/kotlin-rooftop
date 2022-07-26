package com.example.kbsc_cooperate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val rooftop_caption = Color.DarkGray
val rooftop_divider_color = Color.LightGray
private val rooftop_white = Color.White
private val rooftop_skyBlue = Color(0xFF5A9CFF)
private val rooftop_blue = Color(0xFF8BB9FF)




val rooftopColors = lightColors(
    primary = rooftop_white,
    secondary = rooftop_white,
    onSurface = rooftop_skyBlue,
    primaryVariant = rooftop_white,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Composable
fun KBSC_CooperateTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = rooftopColors, typography = rooftopTypography){
    content()
    }
}