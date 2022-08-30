package com.example.kbsc_cooperate.navigation.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kbsc_cooperate.home.MainViewModel
import com.example.kbsc_cooperate.navigation.graph.HomeNavGraph
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme

enum class SearchWidgetState {
    OPENED,
    CLOSED
}

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel,
) {
    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState

    Scaffold(
        topBar = {
            HomeTopBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = { mainViewModel.updateSearchTextState(it) },
                onCloseClicked = { mainViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED) },
                onSearchClicked = { Log.d("검색된 문자", it) },
                onSearchTriggered = { mainViewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED) }
            )
        },
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Box(Modifier.padding(it)) {
            HomeNavGraph(navController = navController)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun HomeContent() {
    val regions = listOf("서울", "부산", "대구", "대전", "인천", "안산", "구미")

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        regions.forEach { region ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(12.dp),
                text = "지역 $region"
                )
            }
            items(10) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "$region 지역으로 부터의 $it 아이템"
                )
            }
        }
    }
}



@Composable
fun HomeTopBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit,
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultTopBar(
                onSearchClicked = onSearchTriggered
            )
        }
        SearchWidgetState.OPENED -> {
            SearchBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}


@Composable
fun DefaultTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "어디로 가실 건가요 ?",
                color = Color.Black,
                fontSize = 17.sp,
            )
        },
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "검색 아이콘",
                    tint = Color.Black
                )
            }
        }
    )
}


@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primary
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "가고싶은 지역 검색",
                    color = Color.Black
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = { /*TODO: 검색 적용화면으로 이동*/}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "검색 아이콘",
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (!text.isNotEmpty()) {
                        onCloseClicked()
                    }
                    onTextChange("")
                }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "아이콘 닫기",
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked(text) }),

            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf<BottomBarScreen>(
        BottomBarScreen.Home,
        BottomBarScreen.Like,
        BottomBarScreen.Profile,
    )
    // AsState를 통해 navBackStackEntry를 가져와 목적지의 route(string)을 가져옴
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color(0xFF3F414E)
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(
        label = {
            Text(text = stringResource(id = screen.name), fontSize = 9.sp)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = stringResource(id = screen.name),
                modifier = Modifier
                    .width(26.dp)
                    .height(26.dp)
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                navController.graph.startDestinationRoute?.let {
                    popUpTo(it) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    )
}

@Preview(showBackground = true)
@ExperimentalFoundationApi
@Composable
fun HomeScreenPreview() {
    KBSC_CooperateTheme {
        //HomeContent()
        SearchBar(text = "", onTextChange = {}, onCloseClicked = { /*TODO*/ }, onSearchClicked = {})
    }
}