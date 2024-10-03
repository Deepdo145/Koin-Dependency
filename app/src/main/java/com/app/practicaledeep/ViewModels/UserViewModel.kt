package com.app.practicaledeep.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.practicaledeep.ApiService.UserRepository
import com.app.practicaledeep.Model.User
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun getUsers() {
        viewModelScope.launch {
            try {
                val response = userRepository.fetchUsers()
                _users.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
