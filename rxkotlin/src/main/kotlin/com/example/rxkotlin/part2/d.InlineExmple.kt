package com.example.rxkotlin.part2

/**
 * Created by AU on 1/9/2018.
 */

inline fun doSomeStuff(a:Int = 0) = a+(a*a)

fun main(args: Array<String>) {
    for (i in 1..10) println("$i Output ${doSomeStuff(i)}")
}
