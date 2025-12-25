package com.example.num_social.feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.R
import com.example.num_social.core.ui.theme.PacificoFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val profileSize = 48.dp


    Scaffold(
        topBar = {
                TopAppBar(
                    modifier = Modifier.padding(bottom = 16.dp),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    ),
                    title = { Text(
                        text = "Uni Social",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = PacificoFont,
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) },
                    actions = {
                        Row(
                            modifier = Modifier.padding(bottom = 10.dp)
                        ){
                            // Add new Post
                            IconButton(onClick = {}) {
                                Image(
                                    painter = painterResource(id = R.drawable.add_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            // Profile
                            IconButton(
                                modifier = Modifier.size(profileSize),
                                onClick = {}
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .border(border = BorderStroke(2.dp, Color.Red), shape = CircleShape)
                                        .size(profileSize),

                                    )
                            }
                        }
                    },


                    )

        },
        content = {paddingValues ->

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.padding(paddingValues)){
                item { Spacer(modifier = Modifier.height(16.dp)) }
                    // Card feed post
            }
        }
    )
}