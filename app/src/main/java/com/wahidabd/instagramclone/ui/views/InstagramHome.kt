package com.wahidabd.instagramclone.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahidabd.instagramclone.R
import com.wahidabd.instagramclone.data.DataDummy

@Composable
fun InstagramHome(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Instagram") },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = Color.Black,
                elevation = 8.dp,
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_instagram),
                            contentDescription = "Instagram"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_send),
                            contentDescription = "Send"
                        )
                    }
                }
            )
        },
        content = {
            InstagramHomeContent()
        }
    )
}

@Composable
fun InstagramHomeContent() {
    Column{
        InstagramStories()
        Divider()
        InstagramPostLists()
    }
}

@Composable
fun InstagramPostLists() {
    val posts = remember {
        DataDummy.storyList.filter { it.storyImage != "" }
    }

    LazyColumn{
        items(
            items = posts,
            itemContent = {
                InstagramListItem(post = it)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramHomePreview(){
    InstagramHome()
}