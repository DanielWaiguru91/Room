package tech.danielwaiguru.room.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    suspend fun addStudent(student: Student):Long
    @Update
    suspend fun editStudent(student: Student)
    @Delete
    suspend fun deleteStudent(student: Student)
    @Query("SELECT * FROM student")
    fun getAllStudents(): LiveData<List<Student>>
    @Query("DELETE FROM student")
    suspend fun deleteAllStudents()
}