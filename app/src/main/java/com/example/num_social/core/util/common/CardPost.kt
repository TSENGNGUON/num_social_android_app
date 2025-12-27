package com.example.num_social.core.util.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.R
import com.example.num_social.core.model.Follow
import com.example.num_social.core.model.Post
import com.example.num_social.core.ui.theme.BlueText
import com.example.num_social.core.ui.theme.BookMarkColor
import com.example.num_social.core.ui.theme.ContentColor
import com.example.num_social.core.ui.theme.FocusColor
import com.example.num_social.core.ui.theme.GreyText2
import com.example.num_social.core.ui.theme.GreyText3
import com.example.num_social.core.ui.theme.LikeColor

@Composable
fun CardPost(
    post: Post,
    onLikedClick: (Boolean) -> Unit,
    onRepostClick: (Boolean) -> Unit,
    onSaveClick: (Boolean) -> Unit
){

    val isLiked =  if (post.isLike) LikeColor else GreyText2
    val isSave =  if (post.isSave) BookMarkColor else GreyText2
    val isPost =  if (post.isReposted) BlueText else GreyText2
    val interactionSource = remember { MutableInteractionSource() }
    val indication = null

    val imageState = rememberPagerState(pageCount = { post.imageUrls.size})

    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            .clickable(
                onClick = {},
                indication = indication,
                interactionSource = interactionSource
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            // Header for profile, username, name other options
            Row(
                modifier = Modifier.fillMaxWidth().padding(all = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    // User profile
                    UserProfile(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(shape = CircleShape),
                        imageResId = R.drawable.profile
                    )
                    // Name and Username
                    Column(modifier = Modifier.padding(start = 10.dp)){
                        Text(
                            text = post.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                        Text(
                            text = "@${post.author.username}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = GreyText2
                        )

                    }
                }
                Row{
                    IconButton(onClick = {
//                        adding options
                    }) {
                        Image(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = null
                        )
                    }
                }
            }
            // Image Post and Content
            Column(
                modifier = Modifier.fillMaxWidth()
            ){

                // Image Post
                Box(modifier = Modifier.fillMaxWidth().aspectRatio(1f))
                {
                    HorizontalPager(
                        state = imageState
                    ) { img ->
                        val image = post.imageUrls[img]
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                                .height(280.dp),
                        )

                    }
                    // Page Indicator overlay
                    if (post.imageUrls.size > 1){
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(10.dp)
                                .background(Color.Black.copy(alpha = 0.3f), shape = CircleShape)
                                .padding(horizontal = 8.dp, vertical = 6.dp)
                        ){
                            Text(
                                text = "${imageState.currentPage + 1}/${post.imageUrls.size}",
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }
                    }
                }


                // Content
                Column(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    )
                ) {
                    Text(
                        text = post.caption,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = ContentColor
                    )
                }
            }
            // Footer for like, comment, share
            Row (verticalAlignment = Alignment.CenterVertically) {
                // Heart
               Row (
                   verticalAlignment = Alignment.CenterVertically,
                   modifier = Modifier.padding(end = 10.dp)
               ){
                   IconButton(onClick = {
                       // Like logic
                       onLikedClick(!post.isLike)
                   }) {
                       Icon(
                           painter = painterResource(id = R.drawable.favorite_24),
                           contentDescription = null,
                           tint = isLiked
                       )
                   }
                   Text(
                       text = post.likesCount.toString()
                   )
               }
                // Repost
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 10.dp)
                ){
                    IconButton(onClick = {
                        // Repost logic
                        onRepostClick(!post.isReposted)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.repeat_24),
                            contentDescription = null,
                            tint = isPost
                        )
                    }
                    Text(
                        text = post.repostsCount.toString()
                    )
                }
                // Save
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = {
                        // Save logic
                        onSaveClick(!post.isSave)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.bookmark_24),
                            contentDescription = null,
                            tint = isSave
                        )
                    }
                }
            }
        }

    }
}

// Image Profile
@Composable
fun UserProfile(
    modifier: Modifier,
    imageResId: Int
){
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "User Profile",
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )

}


// Follow Card
@Composable
fun FollowCard(
    follow: Follow,
    onFollowClick: (String) -> Unit
){
    val interactionSource = remember { MutableInteractionSource() }
    val indication = null



    val buttonStatusText = if (follow.following){
        "Unfollow"
    }else {
        "Follow back"
    }


    val followStatus = when (follow.followStatus) {
        "start_following_you" -> { "Start following you" }
        "following_you" -> { "Following you" }
        else -> { "" }
    }

    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            .clickable(
                onClick = {},
                indication = indication,
                interactionSource = interactionSource
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // User Profile and name
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UserProfile(
                        imageResId = follow.userProfile,
                        modifier = Modifier.size(50.dp)
                            .clip(CircleShape)

                    )

                    Column(modifier = Modifier.padding(start = 6.dp)){
                        // status
                        Text(
                            text = followStatus,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = GreyText3
                        )
                    }
                }

                // response button for follow features
                Button(
                    onClick = {
                        onFollowClick(follow.id)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = getColorButtonStatus(follow)
                    )
                ) {
                    Text(
                        text = buttonStatusText,
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 0.dp, vertical = 0.dp)
                    )
                }
            }

        }

    }

}


fun getColorButtonStatus(follow: Follow): Color {
    return if (follow.following) {
        BlueText // Blue for Unfollow
    }else {
        FocusColor // Pink for follow back
    }
}

