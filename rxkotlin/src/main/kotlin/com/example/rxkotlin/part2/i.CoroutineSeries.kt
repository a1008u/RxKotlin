package com.example.rxkotlin.part2


import kotlin.coroutines.experimental.buildSequence

/**
 * Created by AU on 1/9/2018.
 */

/**
 * takeメソッドは引数に指定したデータ数や期間に達するまで、受け取ったデータを通知するオペレータです。
 * 指定したデータ数や期間に達したら、完了を通知して処理を終了します。
 * もし、指定した範囲が元の生産者が通知するデータ数より多い場合、元のデータをすべて通知して、完了します。
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