package com.example.pokedex_project.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.pokedex_project.repository.FirestoreConnector
import com.example.pokedex_project.model.Routes

class LoginViewModel:ViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnable : LiveData<Boolean> = _isLoginEnabled

    fun onLoginChanged(name:String, password:String){
        _name.value = name
        _password.value = password
        _isLoginEnabled.value = enableLogin(name, password)
    }

    fun enableLogin(name:String, password: String) =
        password.length > 6
}

    fun loginPressed(navController: NavController){
        navController.navigate(Routes.Pokedex.route)
    }

    fun signupPressed(navController: NavController){
        val firestoreConnector = FirestoreConnector()
        firestoreConnector.getUser()
        navController.navigate(Routes.Signup.route)
    }