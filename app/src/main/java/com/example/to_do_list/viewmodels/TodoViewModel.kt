package com.example.to_do_list.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do_list.modal.Result
import com.example.to_do_list.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    private var todoList = MutableLiveData<List<Result>>()
    val todoLiveData: LiveData<List<Result>> get() = todoList

    fun getTodoData(){
        viewModelScope.launch (Dispatchers.IO){
            todoList.postValue(todoRepository.getItem())
        }
    }

    fun addTodoData(todoList: Result){
        viewModelScope.launch (Dispatchers.IO){
            todoRepository.addItem(todoList)
        }
    }

    fun deleteTodoData(todoList: Result){
        viewModelScope.launch (Dispatchers.IO){
            todoRepository.deleteItem(todoList)
        }
    }
}