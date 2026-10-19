package com.example.todolist.data

import androidx.room.Database
import androidx.room3.RoomDatabase

@Database(
    entities =  [TodoEntity::class],
    version = 1,
)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao = TodoDao
}
