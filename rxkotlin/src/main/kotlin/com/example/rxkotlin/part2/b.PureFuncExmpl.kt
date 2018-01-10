package com.example.rxkotlin.part2

/**
 * Created by AU on 1/9/2018.
 */

// pure function
fun square(n:Int):Int = n*n //(1)

fun main(args: Array<String>) {
    println("named pure func square = ${square(3)}")

    val qube = {n:Int -> n*n*n}//(2)
    println("lambda pure func qube = ${qube(3)}")
}

//named pure func square = 9
//lambda pure func qube = 27