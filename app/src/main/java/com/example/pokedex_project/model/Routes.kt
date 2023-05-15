package com.example.pokedex_project.model

sealed class Routes(val route: String) {

    object Login : Routes("LoginScreen")
    object Signup : Routes("SignupScreen")
    object Pokedex : Routes("PokedexScreen")
    object SplashScreen : Routes("SplashScreen")
    object ExpandedPokemon : Routes("ExpandedPokemon")
}