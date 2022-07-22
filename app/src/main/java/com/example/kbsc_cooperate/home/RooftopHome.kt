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
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.kbsc_cooperate.base.RooftopTabs
import com.example.kbsc_cooperate.data.ExploreModel
import com.example.kbsc_cooperate.ui.theme.BottomSheetShape
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class RooftopBottomBarItem {
    ReservationList, Search, Like, MyProfile
}

@Composable
fun RooftopHome(
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
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
    viewModel: MainViewModel,
) {
    val suggestedRegions by viewModel.suggestedRegions.observeAsState()
    var tabSelected by remember { mutableStateOf(RooftopBottomBarItem.ReservationList) }

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerShape = BottomSheetShape,
        frontLayerScrimColor = Color.Unspecified,
        appBar = {
            HomeBottomBar(tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = {
            ClickTabContent(
                widthSize,
                tabSelected,
                viewModel,
                onExploreItemClicked
            )
        },
        frontLayerContent = {
            when (tabSelected) {
                RooftopBottomBarItem.ReservationList -> {
                    /*TODO: 필요한 내용 업데이트*/
                }

                RooftopBottomBarItem.Search -> {
                    /*TODO: 필요한 내용 업데이트*/
                }

                RooftopBottomBarItem.Like -> {
                    /*TODO: 필요한 내용 업데이트*/
                }

                RooftopBottomBarItem.MyProfile -> {
                    /*TODO: 필요한 내용 업데이트*/
                }
            }
        }
    ) {

    }

}


@Composable
private fun HomeBottomBar(
    tabSelected: RooftopBottomBarItem,
    onTabSelected: (RooftopBottomBarItem) -> Unit,
    modifier: Modifier = Modifier,
) {

    RooftopTabs(
        modifier = Modifier,
        titles = RooftopBottomBarItem.values().map { it.name },
        tabSelected = tabSelected,
        onTabSelected = { newTab -> onTabSelected(RooftopBottomBarItem.values()[newTab.ordinal]) }

    )
}

@Composable
private fun ClickTabContent(
    widthSize: WindowWidthSizeClass,
    tabSelected: RooftopBottomBarItem,
    viewModel: MainViewModel,
    onExploreItemClicked: OnExploreItemClicked,
) {

    when (tabSelected) {
        RooftopBottomBarItem.ReservationList -> ReservationListClickTabContent(
            widthSize = widthSize,
            /*TODO: 필요한 변수 생성, 달력 등등..*/
            reservationListUpdates = ReservationListClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked
                /*TODO: 예약목록 레이아웃 업데이트에 필요한 변수*/
            )
        )

        RooftopBottomBarItem.Search -> SearchClickTabContent(
            widthSize = widthSize,

            searchUpdates = SearchClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked
                /*TODO: 검색 레이아웃 업데이트에 필요한 변수*/
            )
        )

        RooftopBottomBarItem.Like -> LikeClickTabContent(
            widthSize = widthSize,

            likeUpdates = LikeClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked
                /*TODO: 좋아요 레이아웃 업데이트에 필요한 변수*/
            )
        )

        RooftopBottomBarItem.MyProfile -> MyProfileClickTabContent(
            widthSize = widthSize,

            myProfileUpdates = MyProfileClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked
                /*TODO: 내 프로필 레이아웃 업데이트에 필요한 변수*/

            )
        )

    }


}

/*TODO: 클릭하고 난 뒤에 레이아웃에 필요한 데이터 클래스 */

data class ReservationListClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
    /*TODO: 예약목록 레이아웃 업데이트에 필요한 변수*/
)

data class SearchClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
    /*TODO: 검색 레이아웃 업데이트에 필요한 변수*/

)

data class LikeClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
    /*TODO: 좋아요 레이아웃 업데이트에 필요한 변수*/
)

data class MyProfileClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
    /*TODO: 내 프로필 레이아웃 업데이트에 필요한 변수*/
)
