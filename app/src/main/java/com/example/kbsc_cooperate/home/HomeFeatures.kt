package com.example.kbsc_cooperate.home

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.kbsc_cooperate.data.Rooftop

@Composable
fun ReservationListClickTabContent(
    widthSize: WindowWidthSizeClass,
    reservationListUpdates: ReservationListClickTabContentUpdates
    /*TODO: 예약목록 레이아웃 업데이트에 필요한 변수*/
) {
    /*TODO: 필요한 크기에 맞게 배열*/
    val columns = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 4
        else -> 1
    }

    /*TODO: 예약목록 레이아웃에 필요한 내용*/
}

@Composable
fun SearchClickTabContent(
    widthSize: WindowWidthSizeClass,
    searchUpdates: SearchClickTabContentUpdates
    /*TODO: 검색 레이아웃 업데이트에 필요한 변수*/

) {

    val columns = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 4
        else -> 1
    }

    /*TODO: 검색 레이아웃에 필요한 내용*/
}

@Composable
fun LikeClickTabContent(
    widthSize: WindowWidthSizeClass,
    likeUpdates: LikeClickTabContentUpdates
    /*TODO: 좋아요 레이아웃 업데이트에 필요한 변수*/

) {

    val columns = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 4
        else -> 1
    }

    /*TODO: 좋아요 레이아웃 필요한 내용*/
}

@Composable
fun MyProfileClickTabContent(
    widthSize: WindowWidthSizeClass,
    myProfileUpdates: MyProfileClickTabContentUpdates
    /*TODO: 내 프로필 업데이트에 필요한 변수*/

) {

    val columns = when (widthSize) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 4
        else -> 1
    }

    /*TODO: 내 프로필 레이아웃에 필요한 내용*/
}
