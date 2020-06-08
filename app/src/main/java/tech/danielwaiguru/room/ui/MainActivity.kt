package tech.danielwaiguru.room.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import tech.danielwaiguru.room.R
import tech.danielwaiguru.room.databinding.ActivityMainBinding
import tech.danielwaiguru.room.db.Student
import tech.danielwaiguru.room.db.StudentDatabase
import tech.danielwaiguru.room.db.StudentRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /**
         * get StudentDao instance
         */
        val studentDao = StudentDatabase.getInstance(application).getStudentDao()
        /**
         * get StudentRepository instance
         */
        val studentRepository = StudentRepository(studentDao)
        /**
         * get viewmodelfactory instance
         */
        val studentViewModelFactory = StudentViewModelFactory(studentRepository)
        /**
         * get student view model class instance
         */
        studentViewModel = ViewModelProvider(this, studentViewModelFactory).get(StudentViewModel::class.java)
        /**
         * assign view model instance to data binding object
         */
        binding.studentViewModel = studentViewModel
        binding.lifecycleOwner = this
        listOfAllStudents()
    }
    private fun setUpRecyclerView(){
        binding.studentsRv.layoutManager = LinearLayoutManager(this)
        listOfAllStudents()
    }
    private fun listOfAllStudents(){
        studentViewModel.allStudents.observe(this, Observer {
            Log.i("Main", it.toString())
            binding.studentsRv.adapter = StudentAdapter(it) { selectedItem: Student -> listItemClicked(selectedItem)}
        })
    }
    private fun listItemClicked(student: Student){
        Toast.makeText(this, "Item ${student.name} clicked", Toast.LENGTH_LONG).show()
        studentViewModel.initUpdateOrDelete(student)
    }
}