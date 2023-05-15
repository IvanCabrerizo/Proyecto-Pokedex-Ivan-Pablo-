package com.example.pokedex_project.repository

import com.example.pokedex_project.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class PokemonRepository {
    private val pokemonApi: PokemonApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokemonApi = retrofit.create(PokemonApi::class.java)
    }

    suspend fun getAllPokemon(): List<Pokemon> {
        val response = pokemonApi.getAllPokemon(limit = 31)
        return response.results.map { result ->
            val id = extractIdFromUrl(result.url)
            pokemonApi.getPokemonById(id)
        }
    }

    private fun extractIdFromUrl(url: String): Int {
        val regex = Regex("https://pokeapi.co/api/v2/pokemon/(\\d+)/")
        val matchResult = regex.find(url)
        return matchResult!!.groupValues[1].toInt()
    }
}

interface PokemonApi {
    @GET("pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limit: Int
    ): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon
}

data class PokemonListResponse(
    val results: List<PokemonListEntry>
)

data class PokemonListEntry(
    val name: String,
    val url: String
)