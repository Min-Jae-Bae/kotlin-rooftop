package com.example.kbsc_cooperate.navigation.screen

import com.example.kbsc_cooperate.R

sealed class BottomBarScreen(
    val name: Int,
    val icon: Int,
    val route: String,
) {
    object Home : BottomBarScreen(
        R.string.홈,
        R.drawable.ic_baseline_home_24,
        HOME
    )

    object Like : BottomBarScreen(
        R.string.좋아요,
        R.drawable.ic_baseline_like,
        LIKE
    )

    object Profile : BottomBarScreen(
        R.string.내_프로필,
        R.drawable.ic_baseline_person_24,
        PROFILE
    )
}

const val HOME = "HOME"
const val LIKE = "LIKE"
const val PROFILE = "PROFILE"