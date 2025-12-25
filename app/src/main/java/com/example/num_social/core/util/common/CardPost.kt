package com.example.num_social.core.util.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.example.num_social.core.model.Post
import com.example.num_social.core.ui.theme.BlueText
import com.example.num_social.core.ui.theme.BookMarkColor
import com.example.num_social.core.ui.theme.ContentColor
import com.example.num_social.core.ui.theme.GreyText2
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
    val isPost =  if (post.isRepost) BlueText else GreyText2
    val interactionSource = remember { MutableInteractionSource() }
    val indication = null


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
                            text = "@${post.username}",
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
                Image(
                    painter = painterResource(id = post.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(280.dp),
                )
                // Content
                Column(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    )
                ) {
                    Text(
                        text = post.content,
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
                       text = post.count.toString()
                   )
               }
                // Repost
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 10.dp)
                ){
                    IconButton(onClick = {
                        // Repost logic
                        onRepostClick(!post.isRepost)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.repeat_24),
                            contentDescription = null,
                            tint = isPost
                        )
                    }
                    Text(
                        text = post.repostCount.toString()
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

