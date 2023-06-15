package com.example.pokedex_project.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.pokedex_project.R


/*
*
* Autor: Pablo
* Pantalla de login atomizada en 3 componenetes
*
* */

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavController) {
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
                .fillMaxWidth()
        ) {
            Column(Modifier.fillMaxSize()) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
                Header(loginViewModel)
            }
        }
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Body(loginViewModel, navController)
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
fun Header(loginViewModel: LoginViewModel) {
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
            contentDescription = "Foto con el nombre pokemon para el login",
            Modifier
                .height(60.dp)
                .constrainAs(foto2) {
                    top.linkTo(parent.top)
                    bottom.linkTo(texto.top)
                    start.linkTo(foto1.end)
                    end.linkTo(parent.end)
                })
        Text(
            text = "End of degree \n project",
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
fun Body(loginViewModel: LoginViewModel, navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        val name: String by loginViewModel.name.observeAsState("")
        val password: String by loginViewModel.password.observeAsState("")
        val isLoginEnabled by loginViewModel.isLoginEnable.observeAsState(false)
        var passwordVisibility by remember { mutableStateOf(false) }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.07f)
        )

        Text(text = "Username", Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)

        TextField(
            value = name,
            onValueChange = {
                loginViewModel.onLoginChanged(it, password = password)
            },
            Modifier
                .padding(40.dp, 16.dp)
                .border(1.dp, Color.Black, RectangleShape),
            maxLines = 1,
            singleLine = true
        )

        Text(text = "Password", Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)

        TextField(
            value = password,
            onValueChange = {
                loginViewModel.onLoginChanged(name = name, password = it)
            },
            Modifier
                .padding(40.dp, 16.dp)
                .border(1.dp, Color.Black, RectangleShape),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val imagen = if (passwordVisibility) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = imagen, contentDescription = "Show password")
                }
            },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }

        )
        Spacer(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        )
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { loginViewModel.loginPressed(navController) },
                enabled = isLoginEnabled
            ) {
                Text(text = "Login")
            }
            Button(onClick = { loginViewModel.signupPressed(navController) }) {
                Text(text = "Signup")
            }
        }
    }
}