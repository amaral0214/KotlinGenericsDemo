package com.zjnh.kotlin.generics

fun main(args: Array<String>) {
    val numberList: List<Number> = listOf(1, 2, 3) //协变

    val intComparable: Comparable<Int> = object : Comparable<Any>{ //逆变
        override fun compareTo(other: Any): Int {
            return 0
        }
    }

    val numberArrayList:MutableList<Number> = mutableListOf(1,3,4) //不变
}

