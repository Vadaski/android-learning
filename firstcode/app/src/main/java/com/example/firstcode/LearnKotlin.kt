package com.example.firstcode

open class Person(var name: String, var age: Int){
//    val name = "Brian"
//    val age = 0

    fun eat(){
        println(name + "is eating. He is "+age+" years old")
    }
}

fun main(){
//    val p = Person()
//    p.eat()
//    val s = Student("01", 5, "Brian", 22)
//    val s1 = Student("02", 22)
//    val s2 = Student()
//    doStudy(s)
    val s = Singleton
}

class Student(var sno: String, var grade: Int, name: String, age: Int) : Person(name, age), Study{

    init {
        println("sno:" + sno + "grade" + grade.toString()+"name:" + name + "age:" + age.toString())
    }

    constructor(name :String, age: Int) : this("00",0,name,age){
    }

    constructor():this("00", 0){
    }

    override fun readBook() {
        println("readBook")
    }

//    override fun doHomeWork() {
//        println("doHomeWork")
//    }
}

interface Study{
    fun readBook()
    fun doHomeWork(){
        println("doHomeWork")
    }
}

fun doStudy(study: Study){
    study.doHomeWork()
    study.readBook()
}

data class CellPhone(val brand: String, val price: Double)

object Singleton