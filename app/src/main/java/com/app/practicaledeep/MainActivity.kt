package com.app.practicaledeep

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.practicaledeep.Adapters.UserAdapter
import com.app.practicaledeep.ViewModels.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe data from ViewModel
        userViewModel.users.observe(this) { users ->
            userAdapter = UserAdapter(users)
            recyclerView.adapter = userAdapter
        }

        // Fetch the users
        userViewModel.getUsers()
        
    }
}
