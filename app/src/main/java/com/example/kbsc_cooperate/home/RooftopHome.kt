package com.example.kbsc_cooperate.home

import androidx.annotation.Size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material.BackdropScaffoldDefaults.frontLayerScrimColor
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.kbsc_cooperate.base.RooftopBottomBar
import com.example.kbsc_cooperate.base.RooftopTabs
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.ui.theme.BottomSheetShape

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class RooftopBottomItem {  /*TODO: BottomItem들을 각각 선태할 수 있게 제작*/
    ReservationList, Search, Like, MyProfile
}

@Composable
fun RooftopHome(
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked, /*TODO:지붕 클릭시 다음화면 이동*/
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.statusBarsPadding()
    ) { contentPadding ->
        RooftopHomeContent(
            modifier = modifier.padding(contentPadding),
            widthSize = widthSize,
            onExploreItemClicked = onExploreItemClicked, /*TODO:지붕 클릭시 다음화면 이동*/
            viewModel = viewModel
        )
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RooftopHomeContent(
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    /*TODO: 필요한 변수들을 지정해야함*/
    val suggestedRegions by viewModel.suggestedRegions.observeAsState()
    var tabSelected by remember { mutableStateOf(RooftopBottomItem.ReservationList)}
    BackdropScaffold(
        modifier = modifier,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerShape = BottomSheetShape,
        frontLayerScrimColor = Color.Unspecified,
        appBar = {
                 /*TODO: HomeBottomBar 불러오기*/
        },
        backLayerContent = {
            /*TODO: 뒤에있는 레이아웃을 만들어야 함*/
        },
        frontLayerContent = {/*TODO: 앞에있는 랜딩레이아웃 만들어야 함*/ }
    ) {

    }

}


@Composable
private fun HomeBottomBar(
    tabSelected: RooftopBottomItem,
    onTabSelected: (RooftopBottomItem) -> Unit,
    modifier: Modifier = Modifier
) {
    RooftopBottomBar(

    )/* { TODO: RooftopTabs 연결하기
        RooftopTabs()

    }*/

}


@Composable
private fun SearchContent(
    widthSize: WindowWidthSizeClass,
    tabSelected: RooftopBottomItem,
    viewModel: MainViewModel,
    /*TODO: 검색에 필요한 부가적인 기능 추가*/
) {

    /*TODO: 탭을 선택하거나 클릭시 검색하는 기능과 엔터를 치면 검색하게 하는 기능 추가*/

}

/*TODO: 검색에 필요한 데이터 클래스 변수 생성해야함
data class LocalSearchContentUpdates()
*/
