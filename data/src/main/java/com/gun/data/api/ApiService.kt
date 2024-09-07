package com.gun.data.api

import com.gun.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("getData/test")
    suspend fun getUsers(): List<User>
}
