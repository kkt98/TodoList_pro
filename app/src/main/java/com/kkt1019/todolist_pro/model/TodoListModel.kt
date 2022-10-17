package com.kkt1019.todolist_pro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoListModel(
    val check : Boolean,
    val list : String
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
