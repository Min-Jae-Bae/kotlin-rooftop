package com.example.kbsc_cooperate.home

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kbsc_cooperate.base.RooftopTabs
import com.example.kbsc_cooperate.data.ExploreModel

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class RooftopBottomBarItem {
    ReservationList, Search, Like, MyProfile
}

/*@Composable
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
            onExploreItemClicked = onExploreItemClicked,
            viewModel = viewModel
        )
    }
}*/


/*@OptIn(ExperimentalMaterialApi::class)
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
                    ExploreSection(
                        widthSize = widthSize,
                        title = stringResource(R.string.예약_목록),
                        exploreList = viewModel.rooftops, // TODO: 예약 목록 제작 교체 필요
                        onItemClicked = onExploreItemClicked )
                }

                RooftopBottomBarItem.Search -> {
                    ExploreSection(
                        widthSize = widthSize,
                        title = stringResource(R.string.검색),
                        exploreList = viewModel.rooftops, // TODO: 검색 홈으로 이동 교체 필요
                        onItemClicked = onExploreItemClicked )

                }

                RooftopBottomBarItem.Like -> {
                    ExploreSection(
                        widthSize = widthSize,
                        title = stringResource(R.string.좋아요),
                        exploreList = viewModel.rooftops, // TODO: 좋아요 목록 생성 교체 필요
                        onItemClicked = onExploreItemClicked )

                }

                RooftopBottomBarItem.MyProfile -> {
                    ExploreSection(
                        widthSize = widthSize,
                        title = stringResource(R.string.내_프로필),
                        exploreList = viewModel.rooftops, // TODO: 내 프로필 목록 생성 교체 필요
                        onItemClicked = onExploreItemClicked )

                }
            }
        }
    )
}*/


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
                onExploreItemClicked = onExploreItemClicked,
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
