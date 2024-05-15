package com.example.athousandbeginningsandendings

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.athousandbeginningsandendings.data.DataSource

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home"){ BookApp(navController = navController)}

        composable(
            "storyPage/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            val book = if (bookId != null) DataSource().getBookById(bookId) else null
            if (book != null) {
                StoryPage(story = book)
            } else {
                // Handle case where book is not found
            }
        }
    }
}
