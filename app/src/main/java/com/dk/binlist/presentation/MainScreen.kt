package com.dk.binlist.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dk.binlist.navigation.AppNavGraph
import com.dk.binlist.navigation.BottomBinBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBinBar(navController = navController)
        }
    ) { paddingValues ->
        AppNavGraph(paddingValues = paddingValues, navController = navController)
    }
}