package com.example.to_do_list.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.to_do_list.modal.Result

@Database(entities = [Result::class], version = 1)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun todoList():TodoDAO

    companion object{
        private var INSTANCE:TodoDatabase?=null

        fun getDatabase(context: Context):TodoDatabase{
            if (INSTANCE==null){
                synchronized(this){
                   INSTANCE=Room.databaseBuilder(context.applicationContext,TodoDatabase::class.java,"ToDoList").build()
                }
            }
            return INSTANCE!!
        }
    }
}