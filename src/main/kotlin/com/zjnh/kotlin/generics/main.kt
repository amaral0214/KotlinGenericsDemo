package com.zjnh.kotlin.generics

import com.google.gson.Gson
import java.io.File

fun main(args: Array<String>) {
    val a = 2
    val b = 3
    val c = maxOf(a, b)
    println(c)
    val complex = Complex(3.0, 4.0)
    val complex2 = Complex(3.0, 5.0)
    println(maxOf(complex, complex2))

    val complex3 = Complex1(3.0, 5.0)
    val complex4 = Complex1(3, 4)

    //伪泛型
    // 泛型参数具体化

    testGenerics<String>() //== println(String::class.java)

    val person=Person("benny",18)
    Gson().toJson(person).let {
        File("person.json").writeText(it)
    }

    val person1:Person=Gson().fromJson(File("person.json").readText())


}

data class Complex1<T:Number>(val a: T, val b: T) {

    override fun toString(): String {
        return "($a+$b i)"
    }
}

data class Complex(val a: Double, val b: Double) : Comparable<Complex> {
    override fun compareTo(other: Complex): Int {
        return (value() - other.value()).toInt()
    }

    fun value(): Double {
        return a * a + b * b
    }

    override fun toString(): String {
        return "($a+$b i)"
    }
}

fun <T : Comparable<T>> maxOf(a: T, b: T): T {
    return if (a < b) b else a//继承自Comparable并自定义CompareTo方法后可使用大小于号
}

inline fun <reified T> testGenerics(){
    println(T::class.java)
}

data class Person(val name:String, val age:Int)

inline fun <reified T> Gson.fromJson(json:String):T =fromJson(json,T::class.java)

