package com.example.num_social.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.num_social.feature.auth.forgot_password.ForgotPasswordScreen
import com.example.num_social.feature.auth.forgot_password.ResetPasswordScreen
import com.example.num_social.feature.auth.forgot_password.SetNewPasswordScreen
import com.example.num_social.feature.auth.login.LoginScreen
import com.example.num_social.feature.auth.register.RegisterScreen
import com.example.num_social.feature.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.path
    ){
        addLoginScreen(navController = navController, navGraphBuilder =  this)
        addRegisterScreen(navController = navController, navGraphBuilder = this)
        addForgotPasswordScreen(navController = navController, navGraphBuilder = this)
        addResetPasswordScreen(navController = navController, navGraphBuilder = this)
        addSetNewPasswordScreen(navController = navController, navGraphBuilder = this)
        addHomeScreen(navController = navController, navGraphBuilder = this)
    }

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

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){
    navGraphBuilder.composable(route = NavRoute.Home.path){
        HomeScreen()
    }
}
