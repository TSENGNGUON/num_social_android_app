package com.example.num_social.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.num_social.core.ui.components.BottomBar
import com.example.num_social.core.ui.components.TopBar
import com.example.num_social.feature.auth.forgot_password.ForgotPasswordScreen
import com.example.num_social.feature.auth.forgot_password.ResetPasswordScreen
import com.example.num_social.feature.auth.forgot_password.SetNewPasswordScreen
import com.example.num_social.feature.auth.login.LoginScreen
import com.example.num_social.feature.auth.register.RegisterScreen
import com.example.num_social.feature.book_mark.BookMarkScreen
import com.example.num_social.feature.favorite.FavoriteScreen
import com.example.num_social.feature.home.HomeScreen
import com.example.num_social.feature.notification.NotificationScreen
import com.example.num_social.feature.search.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Whitelist
    val showBarsRoute = listOf(
        NavRoute.Home.path,
        NavRoute.Search.path,
        NavRoute.Favorite.path,
        NavRoute.Notification.path,
        NavRoute.BookMark.path,
    )

    val shouldShowBars = currentRoute in showBarsRoute

    Scaffold(
        topBar = {
            if (shouldShowBars) {
              if (currentRoute == NavRoute.Notification.path){
                  null
              }else {
                  TopBar()
              }
            }

        },
        content = {innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavRoute.Login.path,
                modifier = Modifier.padding(innerPadding)
            ){
                // normal route without navigation form bottom bars
                addLoginScreen(navController = navController, navGraphBuilder =  this)
                addRegisterScreen(navController = navController, navGraphBuilder = this)
                addForgotPasswordScreen(navController = navController, navGraphBuilder = this)
                addResetPasswordScreen(navController = navController, navGraphBuilder = this)
                addSetNewPasswordScreen(navController = navController, navGraphBuilder = this)


                // for navigation bottom bar
                addHomeScreen(navController = navController, navGraphBuilder = this)
                addBookMarkScreen(navController = navController, navGraphBuilder = this)
                addNotification(navController = navController, navGraphBuilder = this)
                addSearchScreen(navController = navController, navGraphBuilder = this)
                addFavoriteScreen(navController = navController, navGraphBuilder = this)
            }
        },
        bottomBar = {
           if (shouldShowBars){
               BottomBar(navController = navController)
           }
        }
    )
}




private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Login.path){
        LoginScreen(
            navigateToRegister = {
                navController.navigate(NavRoute.Register.path)
            },
            navigateToForgotPassword = {
                navController.navigate(NavRoute.ForgotPassword.path)
            },
            toHomeScreen = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addRegisterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Register.path){
        RegisterScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            }
        )
    }

}

// forgot password
private fun addForgotPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.ForgotPassword.path) {
        ForgotPasswordScreen(
            popBackStack = {navController.popBackStack()},
            toResetPassword = {email ->
               navController.navigate(NavRoute.ResetPassword.withArgs(email))
            }
        )
    }
}

// Reset Password Screen
private fun addResetPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(
        route = NavRoute.ResetPassword.withArgsFormat(NavRoute.ResetPassword.email),
        arguments = listOf(navArgument(NavRoute.ResetPassword.email){
                type = NavType.StringType
            }
        ),

    ){ navBackStackEntry ->
        val email = navBackStackEntry.arguments?.getString(NavRoute.ResetPassword.email)
        ResetPasswordScreen(
            popBackStack = {navController.popBackStack()},
            toSetNewPassword = {
                navController.navigate(NavRoute.SetNewPassword.path)
            },
            email = email!!
        )
    }

}

private fun addSetNewPasswordScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.SetNewPassword.path){
        SetNewPasswordScreen(
            toLoginScreen = {
                navController.navigate(NavRoute.Login.path)
            },
            popBackStack = {
                navController.popBackStack()
            }
        )
    }
}


//  for bottom bar navigation

private fun addBookMarkScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.BookMark.path){
        BookMarkScreen()
    }
}

private fun addNotification(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Notification.path){
        NotificationScreen()
    }
}
private fun addFavoriteScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Favorite.path){
        FavoriteScreen()
    }
}
private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Search.path){
        SearchScreen()
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Home.path){
        HomeScreen()
    }
}
