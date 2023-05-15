package com.example.pokedex_project.Pokedex

import androidx.compose.material.ScaffoldState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex_project.model.Pokemon
import com.example.pokedex_project.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

fun onPokemonClicked(pokemon: Pokemon) {

}

suspend fun getPokemons(): List<Pokemon> {
    val pokemonRepository = PokemonRepository()
    return withContext(Dispatchers.Main) {
        pokemonRepository.getAllPokemon()
    }
}