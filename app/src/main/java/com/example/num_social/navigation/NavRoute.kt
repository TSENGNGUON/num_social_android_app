package com.example.num_social.navigation

sealed class NavRoute(val path: String){
    object Login: NavRoute("login")
    object Register: NavRoute("register")
    object ForgotPassword: NavRoute("forgotPassword")
    object ResetPassword: NavRoute("resetPassword"){
        val email = "email"
    }
    object SetNewPassword: NavRoute("setNewPassword")
    object Home: NavRoute("home")
    object Profile: NavRoute("profile"){
        val id = "id"
        val showDetails = "showDetails"
    }

    fun withArgs(vararg args: String): String{
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // Format for pass Args
    fun withArgsFormat(vararg args: String): String{
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}
