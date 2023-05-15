package com.example.pokedex_project.model

data class Pokemon(
    val name: String,
    val id: Int,
    val sprites: Sprites,
    val weight: Int,
    val height: Int,
    val types: List<Type>,
    val stats: List<Stat>
)



data class Sprites(
    val front_default: String,
    val front_shiny: String,
    val front_female: String?,
    val front_shiny_female: String?,
    val back_default: String,
    val back_shiny: String,
    val back_female: String?,
    val back_shiny_female: String?
)

data class Type(
    val slot: Int,
    val type: TypeInfo
)

data class TypeInfo(
    val name: String,
    val url: String
)

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatInfo
)

data class StatInfo(
    val name: String,
    val url: String
)