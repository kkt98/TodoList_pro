package com.kkt1019.todolist_pro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoListModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int =  0,
    val check : Boolean,
    val list : String
)
