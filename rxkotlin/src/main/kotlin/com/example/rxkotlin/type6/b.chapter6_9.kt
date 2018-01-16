package com.example.rxkotlin.type6

import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(500, TimeUnit.MILLISECONDS).map { "Observable 1 $it" }//(1)
    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS).map { "Observable 2 $it" }//(2)

    Observable.merge(observable1,observable2)
              .subscribe { println("Received $it") }

    runBlocking { delay(1500) }
}

//Received Observable 2 0
//Received Observable 2 1
//Received Observable 2 2
//Received Observable 2 3
//Received Observable 2 4
//Received Observable 1 0 <- Observable 1の結果
//Received Observable 2 5
//Received Observable 2 6
//Received Observable 2 7
//Received Observable 2 8
//Received Observable 1 1 <- Observable 1の結果
//Received Observable 2 9
//Received Observable 2 10
//Received Observable 2 11
//Received Observable 2 12
//Received Observable 2 13
//Received Observable 2 14
//Received Observable 1 2 <- Observable 1の結果