package com.example.athousandbeginningsandendings

import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel(){
    private var currentScreen: String = Screen.Home.name

    fun getCurrentScreen(): Screen {
        return Screen.valueOf(currentScreen)
    }

    fun navigateTo(screen: Screen) {
        currentScreen = screen.toString()
    }


}