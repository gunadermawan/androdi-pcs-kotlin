package com.gun.data.repository

import com.gun.data.api.ApiService
import com.gun.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            apiService.getUsers()
        }
    }
}

