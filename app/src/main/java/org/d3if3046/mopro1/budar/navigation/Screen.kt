package org.d3if3046.mopro1.budar.navigation

sealed class Screen (val route:String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
}