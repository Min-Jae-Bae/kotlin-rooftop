package com.example.kbsc_cooperate.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.kbsc_cooperate.navigation.graph.HomeNavGraph
import com.example.kbsc_cooperate.navigation.graph.RootNavigationGraph
import com.example.kbsc_cooperate.navigation.graph.Screen
import com.example.kbsc_cooperate.ui.theme.KBSC_CooperateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KBSC_CooperateTheme {
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
                    navController.navigate(Screen.Search.route)
                }
            )
        },
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Box(Modifier.padding(it)) {
            HomeNavGraph(navController = navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KBSC_CooperateTheme {
        RootNavigationGraph(navController = rememberNavController())
    }
}

