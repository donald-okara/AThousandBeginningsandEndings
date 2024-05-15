package com.example.athousandbeginningsandendings

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.athousandbeginningsandendings.data.DataSource

enum class Screen {
    Home,
    Story
}

val dataSource = DataSource()
val books = dataSource.getBooks()


@Composable
fun NavGraph(navController: NavHostController, viewModel: NavigationViewModel = viewModel()) {
    val currentScreen = viewModel.getCurrentScreen()

    NavHost(navController = navController, startDestination = Screen.Home.name) {
        composable(route = Screen.Home.name) {
            BookList(
                books = DataSource().getBooks(),
                onCardClicked = { bookId ->
                    viewModel.navigateTo(Screen.Story)
                    navController.navigate("${Screen.Story.name}/$bookId")
                }
            )
        }
        composable(
            route = "${Screen.Story.name}/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            val book = bookId?.let { DataSource().getBookById(it) }
            if (book != null) {
                StoryPage(story = book)
            } else {
                // Handle case where book is not found
            }
        }
    }
}
