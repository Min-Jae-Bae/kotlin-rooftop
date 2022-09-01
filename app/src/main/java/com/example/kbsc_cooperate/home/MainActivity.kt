package com.example.kbsc_cooperate.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.kbsc_cooperate.navigation.content.ListContent
import com.example.kbsc_cooperate.navigation.graph.HomeNavGraph
import com.example.kbsc_cooperate.navigation.graph.RootNavigationGraph
import com.example.kbsc_cooperate.navigation.graph.SearchScreen
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagingApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KBSC_CooperateTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color(0xFF8BB9FF)
                    )
                }
                RootNavigationGraph(navController = rememberNavController())
            }

        }
    }
}

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val getAllImages = mainViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            MainTopBar(
                onSearchClicked = {
                    navController.navigate(SearchScreen.Search.route)
                }
            )
        },
        content = {
            ListContent(items = getAllImages)

            Box(Modifier.padding(it)) {
                HomeNavGraph(navController = navController)
            }
        },
        bottomBar = { BottomBar(navController = navController) },
    )
}


@ExperimentalPagingApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KBSC_CooperateTheme {
        RootNavigationGraph(navController = rememberNavController())
    }
}

