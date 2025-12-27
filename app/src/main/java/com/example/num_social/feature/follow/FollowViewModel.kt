package com.example.num_social.feature.follow

import androidx.lifecycle.ViewModel
import com.example.num_social.R
import com.example.num_social.core.model.Follow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FollowViewModel : ViewModel() {
    private val _followState =
        MutableStateFlow<List<Follow>>(emptyList())

    val followState = _followState.asStateFlow()
    init {
        fetchFollow()
    }

    private fun fetchFollow() {
        val follow = listOf(
            Follow(
                id = "1",
                userProfile = R.drawable.profile,
                followStatus = "start_following_you",
                followedBy = true,
                following = false

            ),
            Follow(
                id = "2",
                userProfile = R.drawable.profile_2,
                followStatus = "following_you",
                followedBy = false,
                following = true
            )
        )

        _followState.value = follow
    }

    fun toggleFollow (userId: String){
        _followState.value = _followState.value.map { follow ->
            if (follow.id == userId){
                // If currently following, set to false (unfollow)
                // If not following, set to true (follow back)
                follow.copy(following = !follow.following)
            }else{
                follow
            }
        }
    }




}