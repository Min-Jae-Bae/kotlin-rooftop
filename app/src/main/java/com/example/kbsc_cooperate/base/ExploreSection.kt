package com.example.kbsc_cooperate.base

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.home.OnExploreItemClicked
import com.example.kbsc_cooperate.ui.theme.BottomSheetShape
import com.example.kbsc_cooperate.ui.theme.rooftop_caption

/*TODO: 하단바에 클릭시 탐구 내용 기능 제작*/

@Composable
fun ExploreSection(
    widthSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    title: String,
    exploreList: List<ExploreModel>,
    onItemClicked: OnExploreItemClicked
) {
    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        Column(modifier = Modifier.padding(start = 24.dp, top = 20.dp, end = 24.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.caption.copy(color = rooftop_caption)
            )
            Spacer(Modifier.height(8.dp))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(200.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    /*TODO: 각각의 아이템 기능에 대한 함수 필요*/
                }
            )
        }
    }

}