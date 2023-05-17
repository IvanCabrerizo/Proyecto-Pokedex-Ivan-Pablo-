package com.example.pokedex_project.ExpandedPokemon

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedex_project.Pokedex.pokemonClicked

@Composable
fun expandedPokemonScreen(
    expandedPokemonViewModel: ExpandedPokemonViewModel,
    navController: NavController
) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (foto, nombre, tipo, stat1, stat2, stat3, stat4, stat5, stat6, peso, altura) = createRefs()
        val (stat12, stat22, stat32, stat42, stat52, stat62) = createRefs()
        val izquierda = createGuidelineFromStart(0.1f)
        val bajofoto = createGuidelineFromTop(0.4f)
        val maxstat: Int = 400
        /*
        *
        * Foto del pokemon
        *
        * */

        AsyncImage(model = pokemonClicked.sprites.front_default,
            contentDescription = "Foto del pokemon",
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(foto) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bajofoto)
                })
        /*
        *
        *
        * Nombre y tipo del pokemon
        *
        * */
        Text(
            text = (pokemonClicked.id.toString() + " " + pokemonClicked.name.toString()),
            Modifier
                .constrainAs(nombre) {
                    top.linkTo(bajofoto)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            fontSize = 32.sp
        )
        /*
        *
        *
        * Tipos de pokemon
        *
        * */
        val type1 = pokemonClicked.types[0]
        val type2 = if (pokemonClicked.types.size > 1) {
            pokemonClicked.types[1].type.name
        } else {
            null
        }
        Text(
            if (type2.isNullOrEmpty()) {
                "Types: ${type1.type.name}"
            } else {
                "Types: ${type1.type.name} and $type2"
            },
            Modifier.constrainAs(tipo) {
                start.linkTo(izquierda)
                top.linkTo(nombre.bottom)
                bottom.linkTo(altura.top)
            },
            fontSize = 24.sp
        )
        /*
        *
        *
        * Altura del pokemon
        *
        * */
        Text(
            text = "Height: " + pokemonClicked.height,
            Modifier.constrainAs(altura) {
                top.linkTo(tipo.bottom)
                start.linkTo(izquierda)
                bottom.linkTo(peso.top)
            },
            fontSize = 24.sp
        )
        Text(
            text = "Weigh: " + pokemonClicked.weight,
            Modifier.constrainAs(peso) {
                top.linkTo(altura.bottom)
                start.linkTo(izquierda)
                bottom.linkTo(stat1.top)
            },
            fontSize = 24.sp
        )
        /*
        *
        *
        *
        *
        * */
        Text(text = "Health",
            Modifier.constrainAs(stat12) {
                start.linkTo(izquierda)
                bottom.linkTo(stat1.top)
            })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[0].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat1) {
                    top.linkTo(peso.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(stat2.top)
                },
            color = Color.Green
        )
        /*
        *
        *
        *
        *
        * */
        Text("Attack", Modifier.constrainAs(stat22) {
            start.linkTo(izquierda)
            bottom.linkTo(stat2.top)
        })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[1].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat2) {
                    top.linkTo(stat1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(stat3.top)
                },
            color = Color.Red
        )
        /*
        *
        *
        *
        *
        * */
        Text(text = "Defense",
            Modifier.constrainAs(stat32) {
                start.linkTo(izquierda)
                bottom.linkTo(stat3.top)
            })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[2].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat3) {
                    top.linkTo(stat2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(stat4.top)
                },
            color = Color.Blue
        )
        /*
        *
        *
        *
        *
        * */
        Text(text = "Special attack",
            Modifier.constrainAs(stat42) {
                start.linkTo(izquierda)
                bottom.linkTo(stat4.top)
            })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[3].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat4) {
                    top.linkTo(stat3.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(stat5.top)
                },
            color = Color.Magenta
        )
        /*
        *
        *
        *
        *
        * */
        Text(text = "Special defense",
            Modifier.constrainAs(stat52) {
                start.linkTo(izquierda)
                bottom.linkTo(stat5.top)
            })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[4].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat5) {
                    top.linkTo(stat4.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(stat6.top)
                },
            color = Color.Cyan
        )
        /*
        *
        *
        *
        *
        * */
        Text(text = "Speed",
            Modifier.constrainAs(stat62) {
                start.linkTo(izquierda)
                bottom.linkTo(stat6.top)
            })
        LinearProgressIndicator(
            progress = finalBaseStat(pokemonClicked.stats[5].base_stat),
            Modifier
                .fillMaxWidth(0.8f)
                .constrainAs(stat6) {
                    top.linkTo(stat5.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            color = Color.Yellow
        )
    }
}