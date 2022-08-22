package com.example.kbsc_cooperate.home

import com.example.kbsc_cooperate.data.ExploreModel

typealias OnExploreItemClicked = (ExploreModel) -> Unit

enum class RooftopItem {
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

/*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RooftopHomeContent(
    widthSize: WindowWidthSizeClass,
    onExploreItemClicked: OnExploreItemClicked,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {
    val suggestedRegions by viewModel.suggestedRegions.observeAsState()
    var tabSelected by remember { mutableStateOf(RooftopItem.ReservationList) }

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerShape = BottomSheetShape,
        frontLayerScrimColor = Color.Unspecified,

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
                RooftopItem.ReservationList -> {
                    ExploreSection(
                        widthSize = widthSize,
                        title = stringResource(R.string.예약_목록),
                        exploreList = viewModel.rooftops,
                        onItemClicked = onExploreItemClicked)
                }

            }
        }
    )
}

*/

/*
@Composable
private fun HomeBottomBar(
    tabSelected: RooftopItem,
    onTabSelected: (RooftopItem) -> Unit,
    modifier: Modifier = Modifier,
) {

    RooftopTabs(
        modifier = Modifier,
        titles = RooftopItem.values().map { it.name },
        tabSelected = tabSelected,
        onTabSelected = { newTab -> onTabSelected(RooftopItem.values()[newTab.ordinal]) }

    )
}
*/


/*

@Composable
private fun ClickTabContent(
    widthSize: WindowWidthSizeClass,
    tabSelected: RooftopItem,
    viewModel: MainViewModel,
    onExploreItemClicked: OnExploreItemClicked,
) {

    when (tabSelected) {
        RooftopItem.ReservationList -> ReservationListClickTabContent(
            widthSize = widthSize,

            reservationListUpdates = ReservationListClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked,
            )
        )

        RooftopItem.Search -> SearchClickTabContent(
            widthSize = widthSize,

            searchUpdates = SearchClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked
            )
        )

        RooftopItem.Like -> LikeClickTabContent(
            widthSize = widthSize,

            likeUpdates = LikeClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked

            )
        )

        RooftopItem.MyProfile -> MyProfileClickTabContent(
            widthSize = widthSize,

            myProfileUpdates = MyProfileClickTabContentUpdates(
                onExploreItemClicked = onExploreItemClicked

            )
        )

    }

}



*/
/*TODO: 클릭하고 난 뒤에 레이아웃에 필요한 데이터 클래스 *//*



data class ReservationListClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
*/
/*TODO: 예약목록 레이아웃 업데이트에 필요한 변수*//*


)

data class SearchClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
*/
/*TODO: 검색 레이아웃 업데이트에 필요한 변수*//*



)

data class LikeClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
*/
/*TODO: 좋아요 레이아웃 업데이트에 필요한 변수*//*


)

data class MyProfileClickTabContentUpdates(
    val onExploreItemClicked: OnExploreItemClicked,
*/
/*TODO: 내 프로필 레이아웃 업데이트에 필요한 변수*//*


)
*/
