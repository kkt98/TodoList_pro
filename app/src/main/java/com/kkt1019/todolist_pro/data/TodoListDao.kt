package com.kkt1019.todolist_pro.data

import androidx.room.*
import com.kkt1019.todolist_pro.model.TodoListModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser( todolistmodel : TodoListModel )

    @Update
    suspend fun updateUser ( todolistmodel: TodoListModel )

    @Delete
    suspend fun deleteUser ( todolistmodel : TodoListModel)

    @Query("SELECT * FROM TodoListModel ORDER BY id ASC") // SELECT문으로 검색된 데이터를 오름차순(ASC)으로 정렬
    fun readAllData() : Flow<List<TodoListModel>> //Flow 코루틴 - 비동기

    @Query("SELECT * FROM TodoListModel WHERE list LIKE :searchQuery")
    fun searchDatabase(searchQuery : String) : Flow<List<TodoListModel>>

}