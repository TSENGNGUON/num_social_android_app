package com.example.num_social.core.model

data class Post(
    val id: String,
    val name : String,
    val username: String,
    val imageUrl: Int,
    val content: String,
    val count: Int,
    val repostCount: Int,
    val isLike: Boolean,
    val isRepost: Boolean,
    val isSave: Boolean
)
