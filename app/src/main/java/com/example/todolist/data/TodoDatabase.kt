package com.example.todolist.data

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase

@Database(
    entities =  [TodoEntity::class],
    version = 1,
)
abstract class TodoDatabase : RoomDatabase() {
    abstract val todoDao: TodoDao
}

object TodoDatabaseProvider {
    @Volatile
    private var INSTANCE: TodoDatabase? = null

    fun provide(context: Context): TodoDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "todo-app"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}