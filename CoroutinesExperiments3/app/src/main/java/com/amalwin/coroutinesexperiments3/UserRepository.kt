package com.amalwin.coroutinesexperiments3

import android.util.Log
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUserListV1(): List<User> {
        delay(5000)
        Log.i("MYTAG", "Returning the list of users !")
        return listOf(
            User(1, "Taro"),
            User(2, "Guna"),
            User(3, "Ragu"),
            User(4, "Rama"),
            User(5, "Venna")
        )
    }

    suspend fun getUserListCount(): Int {
        delay(5000)
        return 5
    }
}