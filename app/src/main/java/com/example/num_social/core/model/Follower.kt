package com.example.num_social.core.model

data class Follow(
    val id: String,
    val username: String? = null,
    val email: String? = null,
    val userProfile: Int,
    val followStatus: String,
    val followedBy: Boolean,
    val following: Boolean
)


