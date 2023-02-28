package com.example.pokedex_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pokedex_project.R
import com.example.pokedex_project.ui.theme.PokedexProjectTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

/*
*
* Autor: Pablo
* Pantalla de login atomizada en 3 componenetes
*
* */

@Composable
fun LoginScreen() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (header, body, footer) = createRefs()
        val guideline1 = createGuidelineFromTop(0.3f)
        Header(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(header) {
                top.linkTo(parent.top)
                bottom.linkTo(guideline1)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
    }
}
/*
*
* Autor: Pablo Muñoz
* Cabezera del login, con los componentes imagen1, imagen2 y texto
*
* */
@Composable
fun Header(modifier: Modifier){
    ConstraintLayout {
        val (foto1, foto2, texto) = createRefs()
        val guia = createGuidelineFromStart(0.1f)
        Image(
            painter = painterResource(id = R.drawable.charmander),
            contentDescription = "Foto de charmander para el login",
            Modifier
                .size(150.dp)
                .constrainAs(foto1) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(guia)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.charmander),
            contentDescription ="Foto con el nombre pokedex para el login",
            Modifier
                .height(100.dp)
                .constrainAs(foto2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(texto.top)
                    start.linkTo(foto1.end)
                    end.linkTo(parent.end)
                })
        Text(text = "End of degree project",
            Modifier.constrainAs(texto) {
                top.linkTo(foto2.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(foto2.start)
                end.linkTo(foto2.end)
            }
        )
        Box(modifier = Modifier.fillMaxWidth())
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PokedexProjectTheme {
        LoginScreen()
    }
}