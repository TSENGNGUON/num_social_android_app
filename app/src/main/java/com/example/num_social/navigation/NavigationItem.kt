package com.example.num_social.navigation

import com.example.num_social.R


data class NavigationItem(
    val icon: Int,
    val path: String
)

val navigationItems = listOf(
    NavigationItem(R.drawable.home_24, NavRoute.Home.path),
    NavigationItem(R.drawable.search_24_filled, NavRoute.Search.path),
    NavigationItem(R.drawable.favorite_24_fill, NavRoute.Favorite.path),
    NavigationItem(R.drawable.notifications_24_fill, NavRoute.Notification.path),
    NavigationItem(R.drawable.bookmark_24_fill, NavRoute.BookMark.path),
)
