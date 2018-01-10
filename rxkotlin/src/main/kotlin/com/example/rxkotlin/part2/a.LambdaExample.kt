package com.example.rxkotlin.part2

import java.util.*

/**
 * Created by AU on 1/9/2018.
 */

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y } // (1)
    println("Sum ${sum(12,14)}")// (2)

    val anonymousMult = {x: Int -> (Random().nextInt(15)+1) * x}// (3)
    println("random output ${anonymousMult(2)}")// (4)

}

//Sum 26
//random output 10