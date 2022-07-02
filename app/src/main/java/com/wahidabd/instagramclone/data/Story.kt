package com.wahidabd.instagramclone.data

data class Story(
    val id: Int,
    val text: String,
    val author: String,
    val handle: String,
    val time: String,
    val authorImage: String,
    val likesCount: Int,
    val commentsCount: Int,
    val retweetCount: Int,
    val source: String,
    val storyImage: String = ""
)