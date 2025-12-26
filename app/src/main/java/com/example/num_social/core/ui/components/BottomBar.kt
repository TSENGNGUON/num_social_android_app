package com.example.num_social.core.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.num_social.core.ui.theme.FocusColor
import com.example.num_social.navigation.navigationItems

@Composable fun BottomBar(navController : NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.White,
    ){
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
            navigationItems.forEach { navItem ->
                val isBottomBarItem = currentRoute == navItem.path
                val focusColor = if (isBottomBarItem) FocusColor else Color(0xFFCFD6DC)
                    NavigationBarItem(
                    modifier = Modifier.weight(1f),
                    selected = currentRoute == navItem.path,
                    onClick = {
                        navController.navigate(navItem.path) {
                            //home → search → profile
                            //Tap home again → stack becomes: home
                            //Clean and Correct back behavior
                            popUpTo(navController.graph.findStartDestination().id){
                                saveState = true
//                                      saveState = true — Save screen
//                                      What it saves
//                                      stateScroll position
//                                      LazyColumn position
//                                      Remembered UI state
//                                      Example:
//                                      You scroll halfway on Home
//                                      Switch to Profile
//                                      Come back → same scroll position

                            }
                            launchSingleTop = true
                            restoreState = true
//                                      restoreState = true — Restore saved state
//                                      restoreState = true
//                                      What it does
//                                      Restores the state saved by saveState = true
//                                      Without this → state is saved but not reused


                        }
                    },
                    icon = { Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = null,
                        tint = focusColor,
                        modifier = Modifier.size(28.dp)
                    ) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )

            }
        }

    }
}