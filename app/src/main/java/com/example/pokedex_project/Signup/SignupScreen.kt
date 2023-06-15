package com.example.pokedex_project.Signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.pokedex_project.R

/*
*
* Autor: Pablo Muñoz
* Pantalla de registro con los valores en el signupviewmodel
*
* */
@Composable
fun SignupScreen(signupViewModel: SignupViewModel, navController: NavController) {
    val username: String by signupViewModel.name.observeAsState("")
    val password: String by signupViewModel.password.observeAsState("")
    val repeatPassword: String by signupViewModel.repeatPassword.observeAsState("")
    val isRegisterEnabled: Boolean by signupViewModel.isRegisterEnabled.observeAsState(false)
    var passwordVisibility by remember { mutableStateOf(false) }
    var rpasswordVisibility by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxWidth()) {
        /*
        *
        * Autor: Pablo Muñoz
        * Diseño para la cabecera
        *
        * */
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.professoroak),
                contentDescription = "Image of professor oak",
                Modifier.size(150.dp)
            )
            Text(text = "What kind \nof trainer \nare you?",Modifier.padding(15.dp), fontSize = 30.sp)
        }
        /*
        *
        * Autor: Pablo Muñoz
        * Diseño para el cuerpo de la pantalla
        *
        * */
        Text(text = "Username",
            Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)
        TextField(
            value = username,
            onValueChange = { signupViewModel.onSignuChanged(it, password, repeatPassword)},
            Modifier
                .padding(40.dp, 16.dp)
                .border(1.dp, Color.Black, RectangleShape)
        )
        Text(text = "Password",
            Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)
        /*
        *
        * Autor: Pablo Muñoz
        * Campo de texto en el que irá la contraseña
        *
        * */
        TextField(
            value = password,
            onValueChange = { signupViewModel.onSignuChanged(username, it, repeatPassword) },
            Modifier
                .padding(40.dp, 16.dp)
                .border(1.dp, Color.Black, RectangleShape),
            trailingIcon = {
                val imagen = if (passwordVisibility) {
                    Icons.Filled.Visibility
                }
                else{
                    Icons.Filled.VisibilityOff
                }
                IconButton(onClick = { passwordVisibility = !passwordVisibility}) {
                    Icon(imageVector = imagen, contentDescription = "Show password")
                }
            },
            visualTransformation = if(passwordVisibility){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
            }
        )
        Text(text = "Repeat password",
            Modifier.padding(60.dp, 12.dp), fontSize = 20.sp)
        /*
        *
        * Autor: Pablo Muñoz
        * Campo de texto en el que se repitirá la contraseña
        *
        * */
        TextField(
            value = repeatPassword,
            onValueChange = {signupViewModel.onSignuChanged(username, password, it)},
            Modifier
                .padding(40.dp, 16.dp)
                .border(1.dp, Color.Black, RectangleShape),
            trailingIcon = {
                val imagen = if (rpasswordVisibility) {
                    Icons.Filled.Visibility
                }
                else{
                    Icons.Filled.VisibilityOff
                }
                IconButton(onClick = { rpasswordVisibility = !rpasswordVisibility}) {
                    Icon(imageVector = imagen, contentDescription = "Show password")
                }
            },
            visualTransformation = if(rpasswordVisibility){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
            }

        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { signupViewModel.signupPressed2(navController) }, enabled = isRegisterEnabled) {
                Text(text = "Signup")
            }
        }

    }


}


