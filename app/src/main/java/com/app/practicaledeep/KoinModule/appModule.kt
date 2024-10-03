package com.app.practicaledeep.KoinModule

import com.app.practicaledeep.ApiService.ApiService
import com.app.practicaledeep.ApiService.UserRepository
import com.app.practicaledeep.ViewModels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    
    // Provide Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    // Provide ApiService
    single { get<Retrofit>().create(ApiService::class.java) }

    // Provide UserRepository
    single { UserRepository(get()) }

    // Provide UserViewModel
    viewModel { UserViewModel(get()) }
}
