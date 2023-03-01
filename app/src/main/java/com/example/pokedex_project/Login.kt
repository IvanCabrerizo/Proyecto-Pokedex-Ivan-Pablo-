package com.example.pokedex_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    /*
     *
     *Autor: Pablo Muñoz
     *Cabezera de la aplicacion ya desarrollada
     *
     * */
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth()) {
            Column(Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp))
                Header()
            }
        }
            Box(
                Modifier
                    .fillMaxSize()){
                    Body()
                }
        }

}
/*
*
* Autor: Pablo Muñoz
* Diseño de la cabezera del login, con los componentes imagen1, imagen2 y texto
*
* */
@Composable
fun Header(){
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
            painter = painterResource(id = R.drawable.logo),
            contentDescription ="Foto con el nombre pokemon para el login",
            Modifier
                .height(60.dp)
                .constrainAs(foto2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(texto.top)
                    start.linkTo(foto1.end)
                    end.linkTo(parent.end)
                })
        Text(text = "End of degree \n project",
            Modifier.constrainAs(texto) {
                top.linkTo(foto2.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(foto2.start)
                end.linkTo(foto2.end)
            }, fontSize = 26.sp, textAlign = TextAlign.Center
        )
    }
}
/*
*
* Autor: Pablo Muñoz
* Diseño del cuerpo del Login
*
* */
@Composable
fun Body(){
    Column(Modifier.fillMaxSize()) {
        var nombre by remember{mutableStateOf("")}
        var constrasena by remember{ mutableStateOf("") }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(0.07f))

        Text(text = "Username", Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)

        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            Modifier.padding(40.dp, 16.dp)
        )

        Text(text = "Password",  Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)

        TextField(
            value = constrasena,
            onValueChange = {constrasena = it},
            Modifier.padding(40.dp, 16.dp)
        )
        Spacer(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f))
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Signup")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PokedexProjectTheme {
        LoginScreen()
    }
}