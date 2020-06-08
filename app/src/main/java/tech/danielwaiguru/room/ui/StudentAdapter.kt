package tech.danielwaiguru.room.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.room.R
import tech.danielwaiguru.room.databinding.StudentItemBinding
import tech.danielwaiguru.room.db.Student

class StudentAdapter(private val studentsList: List<Student>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(private val binding: StudentItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student){
            binding.tvName.text = student.name
            binding.tvCourse.text = student.course
            binding.tvDepartment.text = student.department
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: StudentItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.student_item, parent, false)
        return StudentViewHolder((binding))
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentsList[position])
    }
}