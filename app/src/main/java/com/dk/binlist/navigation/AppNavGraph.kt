package com.dk.binlist.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dk.binlist.presentation.history.HistoryScreen
import com.dk.binlist.presentation.search.SearchScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route,
        modifier = modifier.padding(paddingValues)
    ) {
        composable(Screen.Search.route,
            enterTransition = { slideInHorizontally(tween()) { -it } },
            exitTransition = { slideOutHorizontally(tween()) { -it } }
        ) {
            SearchScreen()
        }
        composable(Screen.History.route,
            enterTransition = { slideInHorizontally(tween()) { it } },
            exitTransition = { slideOutHorizontally(tween()) { it } }
        ) {
            HistoryScreen()
        }
    }
}