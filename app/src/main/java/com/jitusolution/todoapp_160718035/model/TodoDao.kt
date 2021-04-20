package com.jitusolution.todoapp_160718035.model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//kasih pengaturan jika uid sudah ada maka yang terjadi adalah replace, data lama diganti yang baru
    suspend fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo WHERE is_done =0 ORDER BY priority DESC ")
    suspend fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id")
    suspend fun selectTodo(id:Int): Todo

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
            suspend fun update(title:String, notes:String, priority:Int, id:Int)

    @Query("UPDATE todo SET is_done =1 WHERE uuid = :id")
    suspend fun updateDone(id:Int)
    @Delete
    suspend fun deleteTodo(todo:Todo)
}