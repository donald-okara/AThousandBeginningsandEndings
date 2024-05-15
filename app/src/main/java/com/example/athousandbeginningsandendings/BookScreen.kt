package com.example.athousandbeginningsandendings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.athousandbeginningsandendings.data.DataSource
import com.example.athousandbeginningsandendings.model.Book







@Composable
fun BookList(
    books: List<Book>,
    onCardClicked: (Int) -> Unit,
    modifier: Modifier = Modifier)
{
    val scrollState = rememberScrollState()

    LazyColumn(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        items(books) { book ->
            StoryCard(
                story = book,
                onCardClicked = onCardClicked

            )


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryCard(
    story: Book,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onCardClicked: (Int) -> Unit = {}

) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onCardClicked(story.id) },
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 0.dp,
            bottomEnd = 16.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),


        ) {
        Column {
            Text(
                text = "${story.title} by ${story.author}",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp)
            )


            Text(
                text = stringResource(story.story),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(16.dp)
            )
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookApp(
    navController: NavHostController,
    modifier: Modifier = Modifier,

) {
    val viewModel: NavigationViewModel = viewModel()
    val layoutDirection = LocalLayoutDirection.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        }, content = { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(padding)
                    .padding(
                        start = WindowInsets.safeDrawing
                            .asPaddingValues()
                            .calculateStartPadding(layoutDirection),
                        end = WindowInsets.safeDrawing
                            .asPaddingValues()
                            .calculateEndPadding(layoutDirection),
                    ),
            ) {
                NavGraph(navController = navController, viewModel = viewModel)

            }
        }
    )
}



