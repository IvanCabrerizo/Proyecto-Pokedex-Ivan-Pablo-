package com.example.pokedex_project.ExpandedPokemon

import androidx.lifecycle.ViewModel

class ExpandedPokemonViewModel : ViewModel(){

}
fun finalBaseStat(stat: Int): Float {
    return (stat / 150.0).toFloat()
}