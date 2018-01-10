package com.example.rxkotlin.part2


import kotlin.coroutines.experimental.buildSequence

/**
 * Created by AU on 1/9/2018.
 */

fun main(args: Array<String>) {
    val fibonacciSeries = buildSequence {
        var a = 0
        var b = 1
        yield(a)
        yield(b)

        while (true) {
            val c = a+b
            yield(c)
            a=b
            b=c
        }
    }

    println(fibonacciSeries.take(10).toList() )

}

//[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]