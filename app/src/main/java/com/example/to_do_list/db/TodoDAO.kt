package com.example.to_do_list.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.to_do_list.modal.Result

@Dao
interface TodoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item:Result)

    @Delete
    suspend fun deleteItem(item:Result)

    @Query("SELECT*FROM ToDoList")
    suspend fun getItem():List<Result>


}