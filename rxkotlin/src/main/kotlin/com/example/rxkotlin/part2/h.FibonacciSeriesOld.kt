package com.example.rxkotlin.part2

/**
 * Created by AU on 1/9/2018.
 */

fun main(args: Array<String>) {
    var a = 0
    var b = 1
    print("$a, ")
    print("$b, ")

    for(i in 2..9) {
        val c = a+b
        print("$c, ")
        a=b
        b=c
    }
}


//0, 1, 1, 2, 3, 5, 8, 13, 21, 34,