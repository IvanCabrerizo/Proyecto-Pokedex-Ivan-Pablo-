package com.example.pokedex_project.repository

import android.util.Log
import com.example.pokedex_project.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreConnector {

    val db = Firebase.firestore

    val usuariosCollectionRef = db.collection("users")

    fun getUser() {
        usuariosCollectionRef.get()
            .addOnSuccessListener { documents ->
                val users = mutableListOf<User>()
                for (document in documents) {
                    val user = User(
                        document["userName"] as String,
                        document["password"] as String
                    )
                    users.add(user)
                }
                Log.d("Prueba", "Usuarios: $users")
            }
            .addOnFailureListener { e ->
                Log.w("Prueba", "Error al obtener documentos", e)
            }
    }
}