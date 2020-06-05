package tech.danielwaiguru.room.db

class StudentRepository(private val studentDao: StudentDao) {
    val allStudents = studentDao.getAllStudents()

    suspend fun insertStudent(student: Student){
        studentDao.addStudent(student)
    }
    suspend fun updateStudent(student: Student){
        studentDao.editStudent(student)
    }
    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }
    suspend fun deleteAllStudents(){
        studentDao.deleteAllStudents()
    }
}