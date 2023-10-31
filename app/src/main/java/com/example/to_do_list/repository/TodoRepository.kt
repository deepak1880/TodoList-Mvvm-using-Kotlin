package com.example.to_do_list.repository

import com.example.to_do_list.db.TodoDatabase
import com.example.to_do_list.modal.Result

class TodoRepository(private val todoDatabase:TodoDatabase) {

    suspend fun getItem():List<Result>{
     return todoDatabase.todoList().getItem()
    }

    suspend fun addItem(todoItem:Result){
        todoDatabase.todoList().addItem(todoItem)
    }

    suspend fun deleteItem(todoItem: Result){
        todoDatabase.todoList().deleteItem(todoItem)
    }

}