package com.example.pokedex_project.repositories

import com.example.pokedex_project.model.User
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject
constructor(
    private val userList: CollectionReference
){
    fun addNewUser(user: User) {
        try {
            userList.document(user.id).set(user)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun getUserList() : Flow<Result<List<User>>> = flow {
        try {
            emit(Result.Loading<List<User>>())

            val userList = userList.get().await().map{ document ->
                document.toObject(User::class.java)
            }

            emit(Result.Success<List<User>>(data = userList))

        } catch (e: Exception) {
            emit(Result.Error<List<User>>(message = e.localizedMessage ?: "Error Desconocido"))
        }
    }
}