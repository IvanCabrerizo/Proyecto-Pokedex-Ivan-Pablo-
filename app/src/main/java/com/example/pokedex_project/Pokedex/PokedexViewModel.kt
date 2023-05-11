package com.example.pokedex_project.Pokedex

import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex_project.model.Pokemon
import com.example.pokedex_project.repository.PokemonRepository
import kotlinx.coroutines.*

class PokedexViewModel:ViewModel() {

    private val _scaffoldState = MutableLiveData<ScaffoldState>()
    val scaffoldState = _scaffoldState

    fun onPokedexChange(scaffoldState: ScaffoldState){
        _scaffoldState.value = scaffoldState
    }


}

fun onMenuPressed(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState){
    coroutineScope.launch { scaffoldState.drawerState.open() }
}
fun onCloseDrawer(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState){
    coroutineScope.launch { scaffoldState.drawerState.close() }
}
suspend fun getPokemons(): List<Pokemon> {
    /*
    *
    * Ivan aquí va la lista de pokemons
    *
    *
    * */
    val pokemonRepository = PokemonRepository()
    return withContext(Dispatchers.Main) {
        pokemonRepository.getAllPokemon()
    }
}