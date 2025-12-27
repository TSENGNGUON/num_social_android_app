package com.example.num_social.core.model

data class Post(
    val id: String,
    val name : String,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val author: Author,
    val imageUrls: List<Int>,
    val caption: String,
    val likesCount: Int,
    val repostsCount: Int,
    val isLike: Boolean,
    val isReposted: Boolean,
    val isSave: Boolean
)

data class Author(
    val id: String,
    val username: String
)
