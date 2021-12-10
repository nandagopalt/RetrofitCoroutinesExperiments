package com.example.coroutinesexperiments2.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsersList(): List<User> {
        delay(5000)
        return listOf(
            User(1, "Albert"),
            User(2, "Bala"),
            User(3, "Catherine"),
            User(4, "Diana"),
            User(5, "Eliana")
        )
    }
}