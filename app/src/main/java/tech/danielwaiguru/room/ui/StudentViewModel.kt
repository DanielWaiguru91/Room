package tech.danielwaiguru.room.ui

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.danielwaiguru.room.db.Student
import tech.danielwaiguru.room.db.StudentRepository

class StudentViewModel(private val studentRepository: StudentRepository): ViewModel(), Observable {
    val allStudents = studentRepository.allStudents
    private var isUpdateOrDelete = false
    lateinit var studentUpdateOrDelete : Student
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
    fun save(){
        val name: String = inputName.value!!
        val course = inputCourse.value!!
        val department = inputDepartment.value!!
        insertStudent(Student(0, name, course, department))
        inputName.value = null
        inputCourse.value = null
        inputDepartment.value = null
    }
    fun deleteOrDeleteAll(){
        if (isUpdateOrDelete){
            deleteStudent(studentUpdateOrDelete)
        }
        else
        {
            deleteAllStudent()
        }
    }
    fun updateStud(){
        if (isUpdateOrDelete){
            studentUpdateOrDelete.name = inputName.value.toString()
            studentUpdateOrDelete.course = inputCourse.value.toString()
            studentUpdateOrDelete.department = inputDepartment.value.toString()
            updateStudent(studentUpdateOrDelete)
        }

    }
    private fun insertStudent(student: Student){
        viewModelScope.launch {
            studentRepository.insertStudent(student)
        }
    }

    private fun updateStudent(student: Student){
        viewModelScope.launch {
            studentRepository.updateStudent(student)
        }
    }

    private fun deleteStudent(student: Student){
        viewModelScope.launch {
            studentRepository.deleteStudent(student)
        }
    }

    private fun deleteAllStudent(){
        viewModelScope.launch {
            studentRepository.deleteAllStudents()
        }
    }

    fun initUpdateOrDelete(student: Student){
        inputName.value = student.name
        inputCourse.value = student.course
        inputDepartment.value = student.department
        isUpdateOrDelete = true
        studentUpdateOrDelete = student
        saveOrUpdateBtn.value = "Update"
        deleteOrDeleteAll.value = "Delete"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}