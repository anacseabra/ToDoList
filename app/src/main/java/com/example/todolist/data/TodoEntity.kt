package com.example.todolist.data

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
)
