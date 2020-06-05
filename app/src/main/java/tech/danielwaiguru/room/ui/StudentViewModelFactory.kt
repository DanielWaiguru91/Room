package tech.danielwaiguru.room.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tech.danielwaiguru.room.db.StudentRepository
import java.lang.IllegalArgumentException

class StudentViewModelFactory(private val studentRepository: StudentRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)){
            return StudentViewModel(studentRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}