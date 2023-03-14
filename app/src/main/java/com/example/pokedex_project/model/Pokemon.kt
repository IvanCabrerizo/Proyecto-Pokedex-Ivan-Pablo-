package com.example.pokedex_project.model

import androidx.annotation.DrawableRes

data class Pokemon (
    var id:Int,
    var nombre:String,
    var tipo1:String,
    var tipo2:String?,
    var imagen:String
        )