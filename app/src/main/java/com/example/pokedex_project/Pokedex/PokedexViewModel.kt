package com.example.pokedex_project.Pokedex

import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex_project.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
fun getPokemons(): List<Pokemon> {
    /*
    *
    * Ivan aquí va la lista de pokemons
    *
    *
    * */
    var lista = listOf<Pokemon>(
        Pokemon(
            1,
            "Bulbasaur",
            "Planta",
            "Veneno",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            false
        ),
        Pokemon(
            1,
            "Bulbasaur",
            "Planta",
            "Veneno",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            false
        ),
        Pokemon(
            1,
            "Bulbasaur",
            "Planta",
            "Veneno",
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            false
        )
    )
    return lista
}
fun onClickFav(fav:Boolean):Boolean{
    val like:Boolean = !fav
    return like
}
