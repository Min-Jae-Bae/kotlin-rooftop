package com.example.kbsc_cooperate.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.data.Rooftop

@Composable
fun ReservationListClickTabContent(
    widthSize: WindowWidthSizeClass,
    reservationListUpdates: ReservationListClickTabContentUpdates

) {
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


// 검색 추가
@Composable
private fun RooftopSearch(
    columns: Int,
    content: LazyGridScope.() -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 12.dp),
        columns = GridCells.Fixed(columns),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}