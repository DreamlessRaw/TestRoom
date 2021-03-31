package com.example.testroom

import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    fun insert(todo: Todo): Long

    @Update
    fun update(todo: Todo)

    @Query("select * from todo")
    fun select(): MutableList<Todo>

    @Query("delete from todo where id = :id")
    fun deleteById(id: Int): Int
}