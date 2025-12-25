package com.example.num_social.core.util.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.R
import com.example.num_social.core.model.Post
import com.example.num_social.core.ui.theme.ContentColor
import com.example.num_social.core.ui.theme.GreyText2

@Composable
fun CardPost(post: Post){
    Card(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
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
            Row {  }
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

@Preview(showBackground = true)
@Composable
fun PreviewCardPost(){
    CardPost(
        post = Post(
            id = "1",
            name = "Meng Sea",
            username = "mengsea123",
            imageUrl = R.drawable.profile,
            content = "On a first-time visit to New Orleans, there's so much to see and do."
        )
    )
}