package com.example.num_social.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.num_social.R
import com.example.num_social.core.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel(){
    private val _postsState = 
        MutableStateFlow<List<Post>>(emptyList())
    val postsState = _postsState.asStateFlow()

    init {
        //Simulate API Call
        fetchPosts()
    }

    // Display data for post
    private fun fetchPosts(){
        viewModelScope.launch {
            // mock data and we can replace with the real API data
            val posts = listOf(
                Post("1", "Meng Sea", "mengsea123", R.drawable.profile, content = "Hello", count = 10, repostCount = 5, isLike = true,  isRepost = false,isSave = true),
                Post("2", "Sok Dara", "Gojo123@123", R.drawable.profile, content = "Happy chrismas", count = 400, repostCount = 30, isLike = false,  isRepost = false,isSave = false),
                Post("3", "Peng Chaitit", "tit@123", R.drawable.profile, content = "Test content", count = 30, repostCount = 4, isLike = false,  isRepost = false,isSave = false),
            )
            _postsState.value = posts
        }
    }
    // Liked or Fav action
    fun likePost(postId: String, isLiked: Boolean) {
        // Update state in viewModel
        _postsState.value = _postsState.value.map {
            post ->
            if (post.id == postId) {
                post.copy( isLike = isLiked)
            }
            else{
                post
            }
        }
        // Here you would also call your repository to update the API/database
        updateApi(postId, isLiked)
    }
    // Repost action
    fun repost(postId: String, isRepost: Boolean){
        _postsState.value = _postsState.value.map { post ->
            if (post.id == postId){
                post.copy(isRepost = isRepost)
            }else{
                post
            }
        }
    }
    fun save(postId: String, isSave: Boolean){
        _postsState.value = _postsState.value.map { post ->
            if (post.id == postId){
                post.copy(isSave = isSave)
            }else{
                post
            }
        }
    }
    // Simulate
    private fun updateApi(postId: String, isLiked: Boolean){
        Log.d("updateApi", "postId: $postId,d: $isLiked")
    }



}