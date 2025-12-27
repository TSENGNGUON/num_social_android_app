package com.example.num_social.feature.follow

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.num_social.core.util.common.FollowCard

@Composable
fun FollowScreen(viewModel: FollowViewModel = viewModel()){
    val followState by viewModel.followState.collectAsState()
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ){
        item { Spacer(modifier = Modifier.height(16.dp)) }
        // Card feed post
        items(items = followState){followItem ->
            FollowCard(
                follow = followItem,
                onFollowClick = { userId ->
                    viewModel.toggleFollow(userId)
                }
            )
        }

        item { Spacer(modifier = Modifier.height(28.dp)) }
    }
}