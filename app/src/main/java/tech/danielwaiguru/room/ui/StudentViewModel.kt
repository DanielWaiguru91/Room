package tech.danielwaiguru.room.ui

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.danielwaiguru.room.db.StudentDao
import tech.danielwaiguru.room.db.StudentRepository

class StudentViewModel(private val studentRepository: StudentRepository): ViewModel() {
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputCourse = MutableLiveData<String>()
    @Bindable
    val inputDepartment = MutableLiveData<String>()
}