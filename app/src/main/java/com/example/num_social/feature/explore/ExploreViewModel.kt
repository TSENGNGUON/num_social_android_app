package com.example.num_social.feature.explore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.num_social.R
import com.example.num_social.core.model.Author
import com.example.num_social.core.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExploreViewModel : ViewModel() {
    private val _exploreState = MutableStateFlow<List<Post>>(emptyList())
    val exploreState = _exploreState.asStateFlow()

    init {
        fetchExplorePost()
    }

    private fun fetchExplorePost() {
        viewModelScope.launch {
            val explorePosts = listOf(
                Post(
                    "1",
                    "Meng Sea",
                    imageUrls = listOf(
                        R.drawable.profile,
                        R.drawable.profile,
                        R.drawable.profile
                    ),
                    caption = "Hello",
                    likesCount = 10,
                    repostsCount = 5,
                    isLike = true,
                    isReposted = false,
                    isSave = true,
                    author = Author(
                        id = "1",
                        username = "mengsea123"
                    )
                ),
                Post(
                    "2",
                    "Sok Dara",
                    imageUrls = listOf(
                        R.drawable.profile,
                        R.drawable.profile,
                    ),
                    caption = "Happy chrismas",
                    likesCount = 400,
                    repostsCount = 30,
                    isLike = false,
                    isReposted = false,
                    isSave = false,
                    author = Author(
                        id = "2",
                        username = "Gojo123@123"
                    )
                ),
                Post(
                    "3",
                    "Peng Chaitit",
                    imageUrls = listOf(
                        R.drawable.profile,
                    ),
                    caption = "Test content",
                    likesCount = 30,
                    repostsCount = 4,
                    isLike = false,
                    isReposted = false,
                    isSave = false,
                    author = Author(
                        id = "3",
                        username = "tit@123"
                    )
                ),
            )

            _exploreState.value = explorePosts
        }
    }

    fun likePost(postId: String, isLiked: Boolean){
        _exploreState.value = _exploreState.value.map { post ->
            if (post.id == postId){
                post.copy(isLike = isLiked)
            }else {
                post
            }
        }
        updateApi(postId, isLiked)

    }

    fun repost(postId: String, isRepost: Boolean){
        _exploreState.value = _exploreState.value.map {
            post ->
            if (post.id == postId){
                post.copy(isReposted = isRepost)
            }else{
                post
            }
        }
        updateApi(postId, isRepost)
    }

    fun save(postId: String, isSave: Boolean){
        _exploreState.value = _exploreState.value.map {post ->
            if (post.id == postId){
                post.copy(isSave = isSave)
            }else{
                post
            }
        }
    }

    private fun updateApi(postId: String, isLiked: Boolean){
        Log.d("updateApi", "postId: $postId,d: $isLiked")
    }



}