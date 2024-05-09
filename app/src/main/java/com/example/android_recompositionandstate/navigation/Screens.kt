package com.example.android_recompositionandstate.navigation

sealed class Screens (val route: String){
    data object Home: Screens("home")
    data object List: Screens("list")
    data object About: Screens("about")
    data object Detail: Screens("detail")
}