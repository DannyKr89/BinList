package com.dk.binlist.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.dk.binlist.utils.Consts

sealed class Screen(val route: String, val icon: ImageVector) {
    data object Search : Screen(Consts.ROUTE_SEARCH_SCREEN, Icons.Default.Search)
    data object History : Screen(Consts.ROUTE_HISTORY_SCREEN, Icons.Default.Menu)
}