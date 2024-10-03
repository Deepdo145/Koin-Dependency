package com.app.practicaledeep.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun fetchUsers() = apiService.getUsers()
}