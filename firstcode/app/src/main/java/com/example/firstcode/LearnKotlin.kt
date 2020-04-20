package com.example.firstcode

import kotlin.math.max

fun main(){
    var a : Int
    val x = 10
    val y = 20
    a = getMax(x, y)
    println("large number is " + a)
    println("Tom's get " + getScore("Tom")+" score")
    checkNumber(12.0)
    println("1 is Int "+ (1 is Int))
    val m = MyType()
    println("m is MyType "+(m is MyType))
}

fun getMax(a: Int, b: Int): Int = if(a > b) a else b

fun getScore(name: String) = when (name){
    "Tom" -> 64
    "Jim" -> 77
    "Mike" -> 48
    else -> null
}

fun checkNumber(num: Number) = when(num){
    is Int -> println("num is Int")
    is Double -> println("num is double")
    else -> print("wrong type")
}

class MyType