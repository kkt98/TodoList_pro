package com.kkt1019.todolist_pro.repository

import com.kkt1019.todolist_pro.data.TodoListDao
import com.kkt1019.todolist_pro.model.TodoListModel
import kotlinx.coroutines.flow.Flow

// 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할 - repository
class TodoListRepository(private val todoListDao: TodoListDao) {

    val readAllData : Flow<List<TodoListModel>> = todoListDao.readAllData()

    suspend fun addUser(todoListModel: TodoListModel){
        todoListDao.addUser(todoListModel)
    }

    suspend fun updateUser(todoListModel: TodoListModel){
        todoListDao.updateUser(todoListModel)
    }

    suspend fun deleteUser(todoListModel: TodoListModel){
        todoListDao.deleteUser(todoListModel)
    }

    fun searchDatabase(searchQuery : String): Flow<List<TodoListModel>>{
        return todoListDao.searchDatabase(searchQuery)
    }

}