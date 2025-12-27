package com.example.num_social.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.num_social.R
import com.example.num_social.core.ui.theme.PacificoFont
import com.example.num_social.navigation.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController){
    val backStackEntry by  navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val showPostButton = NavRoute.Home.path
    val shouldShowPostButton = currentRoute == showPostButton

    val profileSize = 48.dp
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
                if (shouldShowPostButton) {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.add_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
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
                            .border(
                                border = BorderStroke(2.dp, Color.Red),
                                shape = CircleShape
                            )
                            .size(profileSize),

                        )
                }
            }
        },


        )
}