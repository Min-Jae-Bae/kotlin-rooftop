package com.example.kbsc_cooperate.home

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kbsc_cooperate.navigation.screen.BottomBarScreen
import com.example.kbsc_cooperate.ui.theme.topAppBarBackgroundColor
import com.example.kbsc_cooperate.ui.theme.topAppBarContentColor

@Composable
fun MainTopBar(
    onSearchClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "홈",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "검색 아이콘"
                )


            }
        }
    )
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
