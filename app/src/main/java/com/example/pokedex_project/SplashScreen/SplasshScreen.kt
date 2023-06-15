package com.example.pokedex_project.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.pokedex_project.R
import com.example.pokedex_project.model.Routes
import com.example.pokedex_project.model.User
import com.example.pokedex_project.repository.FirestoreConnector
import kotlinx.coroutines.delay
class splashScreen{
    companion object{
        var userList = mutableListOf<User>()
    }
}
@Composable
fun SplasshScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        val firestoreConnector = FirestoreConnector()
        splashScreen.userList = firestoreConnector.getUser()
        navController.navigate(Routes.Login.route)
    }
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (pokeball, pablo, ivan, pokedex) = createRefs()
        val midguideline = createGuidelineFromTop(0.5f)
        val nameguideline = createGuidelineFromTop(0.7f)
        val nameguideline2 = createGuidelineFromTop(0.9f)
        Image(painter = painterResource(id = R.drawable.pokeball),
            contentDescription = "Pokeball as the logo for the app",
            Modifier
                .fillMaxWidth(0.7f)
                .constrainAs(pokeball) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(midguideline)
                })
        Image(painter = painterResource(id = R.drawable.pokedex),
            contentDescription = "Texto que dice Pokedex",
            Modifier
                .fillMaxSize(0.4f)
                .constrainAs(pokedex) {
                    top.linkTo(pokeball.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(midguideline)
                })
        Image(painter = painterResource(id = R.drawable.ivan),
            contentDescription = "Pone ivan",
            Modifier
                .fillMaxSize(0.4f)
                .constrainAs(ivan) {
                    top.linkTo(nameguideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(nameguideline2)
                })
        Image(painter = painterResource(id = R.drawable.pablo),
            contentDescription = "Pone pablo",
            Modifier
                .fillMaxSize(0.4f)
                .constrainAs(pablo) {
                    top.linkTo(nameguideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
    }
}

