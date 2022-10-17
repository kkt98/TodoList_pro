package com.kkt1019.todolist_pro.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// entities = 사용할 엔티티 선언, version = 엔티티 구조 변경 시 구분해주는 역할, exportSchema = 스키마 내보내기 설정
@Database(entities = [TodoListDatabase::class], version = 1, exportSchema = false)
abstract class TodoListDatabase : RoomDatabase() {

    abstract fun todoListDao() : TodoListDao

    companion object{

        @Volatile
        private var instance : TodoListDatabase? = null

        fun getDatabase(context: Context) : TodoListDatabase? {
            if(instance == null){

                // synchronized(동기화)는 하나의 객체에 여러 개의 객체가 동시에 접근해 처리하는 것을 막기 위해 사용
                synchronized(TodoListDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoListDatabase::class.java,
                        "todolist_Database"
                    ).build()
                }

            }

            return instance
        }
    }

}