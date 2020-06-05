package tech.danielwaiguru.room.ui

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.room.db.Student
import tech.danielwaiguru.room.db.StudentDao
import tech.danielwaiguru.room.db.StudentRepository

class StudentViewModel(private val studentRepository: StudentRepository): ViewModel() {
    val allStudents = studentRepository.allStudents
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputCourse = MutableLiveData<String>()
    @Bindable
    val inputDepartment = MutableLiveData<String>()

    /**
     * Binding the buttons to change the text dynamically
     */
    @Bindable
    val saveOrUpdateBtn = MutableLiveData<String>()
    @Bindable
    val deleteOrDeleteAll = MutableLiveData<String>()

    init {
        saveOrUpdateBtn.value = "Save"
        deleteOrDeleteAll.value = "Delete All"
    }
    fun insertStudent(student: Student){
        viewModelScope.launch {
            studentRepository.insertStudent(student)
        }
    }
    fun updateStudent(student: Student){
        viewModelScope.launch {
            studentRepository.updateStudent(student)
        }
    }
    fun deleteStudent(student: Student){
        viewModelScope.launch {
            studentRepository.deleteStudent(student)
        }
    }
    fun deleteAllStudent(){
        viewModelScope.launch {
            studentRepository.deleteAllStudents()
        }
    }
}