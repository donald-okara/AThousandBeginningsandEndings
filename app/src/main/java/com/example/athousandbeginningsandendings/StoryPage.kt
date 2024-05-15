package com.example.athousandbeginningsandendings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.athousandbeginningsandendings.model.Book

@Composable
fun StoryPage(
    story : Book,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(16.dp)
            ) {
                Text(
                    text = story.title,
                    style = MaterialTheme.typography.headlineLarge,
                )
                Text(
                    text = story.author,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Text(
                    text = stringResource(id = story.story),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
    }
}