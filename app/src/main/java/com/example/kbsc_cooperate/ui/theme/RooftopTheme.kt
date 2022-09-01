package com.example.kbsc_cooperate.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val rooftop_caption = Color.DarkGray
val rooftop_divider_color = Color.LightGray
private val rooftop_white = Color.White
private val rooftop_skyBlue = Color(0xFF5A9CFF)
private val rooftop_blue = Color(0xFF8BB9FF)

val Colors.topAppBarContentColor: Color
    get() = if (isLight) Color.Black else Color.LightGray

val Colors.topAppBarBackgroundColor: Color
    get() = if (isLight) Color.White else Color.Black


        @SuppressLint("ConflictingOnColor")
        val rooftopColors = lightColors(
            primary = rooftop_white,
            onSecondary = rooftop_blue,
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


@Composable
fun KBSC_CooperateTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = rooftopColors, typography = rooftopTypography){
    content()
    }
}