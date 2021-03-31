package com.example.testroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    var title: String,
    var content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}