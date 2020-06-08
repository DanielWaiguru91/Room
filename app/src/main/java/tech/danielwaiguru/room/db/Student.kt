package tech.danielwaiguru.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    var course: String,
    var department: String
)