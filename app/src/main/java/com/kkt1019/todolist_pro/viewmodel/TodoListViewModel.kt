package com.kkt1019.todolist_pro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kkt1019.todolist_pro.data.TodoListDatabase
import com.kkt1019.todolist_pro.model.TodoListModel
import com.kkt1019.todolist_pro.repository.TodoListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class TodoListViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData : LiveData<List<TodoListModel>>
    private val repository : TodoListRepository

    init {
        val todoListDao = TodoListDatabase.getDatabase(application)!!.todoListDao()
        repository = TodoListRepository(todoListDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addUser(todoListModel: TodoListModel){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(todoListModel)
        }
    }

    fun updateUser(todoListModel: TodoListModel){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(todoListModel)
        }
    }

    fun deleteUser(todoListModel: TodoListModel){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(todoListModel)
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<TodoListModel>>{
        return repository.searchDatabase(searchQuery).asLiveData()
    }

}