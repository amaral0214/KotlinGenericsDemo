package com.zjnh.kotlin.generics

fun main(args: Array<String>) {
    val list:List<*> = listOf(1,2)
    val list1:List<Any?> = listOf(1,2)//泛型类型转化为最父类 最大 List<*>即List<Any?>
    list[1]

    val comparable:Comparable<*> = object :Comparable<Any>{
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
    val comparable1:Comparable<Nothing> = object :Comparable<Any>{
        override fun compareTo(other: Any): Int {
            return 0
        }
    }

    val mutableList:MutableList<*> = mutableListOf(1,2,3)

    val raw1=Raw<String>()
    val raw:Raw<*> =Raw.getRaw()

}


open class Hello<T>

class Hello2<T>

class SonOfHello:Hello<Hello2<*>>()