package com.app.practicaledeep.ApiService

import com.app.practicaledeep.Model.User
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getUsers(): List<User>
}