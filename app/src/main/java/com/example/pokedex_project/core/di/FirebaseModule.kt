package com.example.pokedex_project.core.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    /*
    *
    *Autor: Iván Cabrerizo
    *-Funcion para obtener la instancia de firebase y asi acceder a nuestra BD de firestore mediante
    * el uso de inyeccion de dependencias con Dagger Hilt.
    *
    */

    @Singleton
    @Provides
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()


    /*
    *
    *Autor: Iván Cabrerizo
    *-Funcion para obtener la lista de usuarios de nuestra BD en firestore.
    *
    */

    @Singleton
    @Provides
    fun provideUserList(
        firestore: FirebaseFirestore
    ) = firestore.collection("users")
}