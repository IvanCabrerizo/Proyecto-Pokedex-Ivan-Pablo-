package com.example.pokedex_project.model

import com.example.pokedex_project.Login.LoginScreen

sealed class Routes(val route: String) {

    object Login:Routes("LoginScreen")
    object Signup:Routes("SignupScreen")

}