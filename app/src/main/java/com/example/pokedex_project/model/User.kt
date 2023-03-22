package com.example.pokedex_project.model

data class User(
    val id: String,
    val userName: String,
    val password: String
){
    constructor() : this("", "", "")
}
