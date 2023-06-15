package com.example.pokedex_project.Login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.pokedex_project.SplashScreen.splashScreen
import com.example.pokedex_project.model.Routes

class LoginViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnabled

    fun onLoginChanged(name: String, password: String) {
        _name.value = name
        _password.value = password
        _isLoginEnabled.value = enableLogin(name, password)
    }

    fun enableLogin(name: String, password: String) = password.length > 4 && name.length > 4

    fun loginPressed(navController: NavController) {
        val username = _name.value
        val password = _password.value

        if (username != null && password != null) {
            val isLoggedIn =
                splashScreen.userList.any { it.userName == username && it.password == password }
            if (isLoggedIn) {
                navController.navigate(Routes.Pokedex.route)
            } else {
                val toastMessage = "Credenciales incorrectas"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(navController.context, toastMessage, duration).show()
            }
        }
    }

    fun signupPressed(navController: NavController) {
        navController.navigate(Routes.Signup.route)
    }
}