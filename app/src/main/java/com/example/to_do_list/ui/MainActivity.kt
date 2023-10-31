package com.example.to_do_list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.to_do_list.R
import com.example.to_do_list.db.TodoDatabase
import com.example.to_do_list.modal.Result
import com.example.to_do_list.repository.TodoRepository
import com.example.to_do_list.viewmodels.TodoViewModel
import com.example.to_do_list.viewmodels.TodoViewModelFactory

class MainActivity : AppCompatActivity() {

    private var todoViewModel:TodoViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        observerTodoData()

    }
    private fun observerTodoData() {
        val todoDatabase=TodoDatabase.getDatabase(this)
        val repository=TodoRepository(todoDatabase)
        todoViewModel= ViewModelProvider(this,TodoViewModelFactory(repository))[TodoViewModel::class.java]

        todoViewModel!!.addTodoData(Result(1,"Walking","I walked 10km",true))
        todoViewModel!!.addTodoData(Result(2,"Walking","I walked 10km",true))
        todoViewModel!!.addTodoData(Result(3,"Run","To much Run",false))

    }
}