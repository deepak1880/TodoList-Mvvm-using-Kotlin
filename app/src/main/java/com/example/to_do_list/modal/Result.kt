package com.example.to_do_list.modal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoList")
data class Result(
    @PrimaryKey(autoGenerate = true)
 val id:Int,
 val title :String,
 val description:String,
 val isCompleted:Boolean
)
