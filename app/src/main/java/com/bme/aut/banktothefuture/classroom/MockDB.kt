package com.bme.aut.banktothefuture.classroom

class MockDB {

    private val studentList = ArrayList<Student>()
    private val data1 = Student("15000", "Zita")
    private val data2 = Student( "12500","Berci")
    private val data3 = Student("9500", "Döme")
    private val data4 = Student("8500","Zsófi")
    private val data5 = Student("4000","Petya")
    private val data6 = Student("3500","Niki")
    private val data7 = Student("2500","Bálint")

    init {

            studentList.add(data1)
            studentList.add(data2)
            studentList.add(data3)
            studentList.add(data4)
            studentList.add(data5)
            studentList.add(data6)
            studentList.add(data7)

    }

    fun getStudentList():ArrayList<Student> {
        return studentList
    }
}