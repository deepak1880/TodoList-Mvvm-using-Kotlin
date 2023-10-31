package com.example.to_do_list.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.to_do_list.repository.TodoRepository

class TodoViewModelFactory(private val todoRepository: TodoRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(todoRepository) as T
    }
}