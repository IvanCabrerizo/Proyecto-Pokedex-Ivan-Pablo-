package com.example.pokedex_project.Pokedex

import androidx.compose.material.ScaffoldState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.pokedex_project.model.Pokemon
import com.example.pokedex_project.model.Routes
import com.example.pokedex_project.model.Sprites
import com.example.pokedex_project.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var pokemonClicked = Pokemon(
    name = "",
    id = 0,
    sprites = Sprites(
        front_default = "",
        front_shiny = "",
        front_female = null,
        front_shiny_female = null,
        back_default = "",
        back_shiny = "",
        back_female = null,
        back_shiny_female = null
    ),
    weight = 0,
    height = 0,
    types = emptyList(),
    stats = emptyList()
)

class PokedexViewModel : ViewModel() {

    private val _scaffoldState = MutableLiveData<ScaffoldState>()
    val scaffoldState = _scaffoldState

    fun onPokedexChange(scaffoldState: ScaffoldState) {
        _scaffoldState.value = scaffoldState
    }
}

fun onMenuPressed(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState) {
    coroutineScope.launch { scaffoldState.drawerState.open() }
}

fun onCloseDrawer(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState) {
    coroutineScope.launch { scaffoldState.drawerState.close() }
}

fun onPokemonClicked(pokemon: Pokemon, navController: NavController) {
    pokemonClicked = pokemon
    navController.navigate(Routes.ExpandedPokemon.route)
}

suspend fun getPokemons(): List<Pokemon> {
    val pokemonRepository = PokemonRepository()
    return withContext(Dispatchers.Main) {
        pokemonRepository.getAllPokemon()
    }
}