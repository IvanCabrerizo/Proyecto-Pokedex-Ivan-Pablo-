package com.example.pokedex_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex_project.ExpandedPokemon.ExpandedPokemonViewModel
import com.example.pokedex_project.ExpandedPokemon.expandedPokemonScreen
import com.example.pokedex_project.Login.LoginScreen
import com.example.pokedex_project.Login.LoginViewModel
import com.example.pokedex_project.Pokedex.PokedexScreen
import com.example.pokedex_project.Pokedex.PokedexViewModel
import com.example.pokedex_project.Signup.SignupScreen
import com.example.pokedex_project.Signup.SignupViewModel
import com.example.pokedex_project.SplashScreen.SplasshScreen
import com.example.pokedex_project.model.Routes
import com.example.pokedex_project.ui.theme.PokedexProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.SplashScreen.route
                    ) {
                        composable(Routes.SplashScreen.route) { SplasshScreen(navController = navigationController) }
                        composable(Routes.Login.route) {
                            LoginScreen(
                                LoginViewModel(),
                                navigationController
                            )
                        }
                        composable(Routes.Signup.route) {
                            SignupScreen(
                                SignupViewModel(),
                                navigationController
                            )
                        }
                        composable(Routes.Pokedex.route) {
                            PokedexScreen(
                                PokedexViewModel(),
                                navigationController
                            )
                        }
                        composable(Routes.ExpandedPokemon.route) {
                            expandedPokemonScreen(
                                ExpandedPokemonViewModel(),
                                navigationController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Este es el merge a la rama master" + name)
}

