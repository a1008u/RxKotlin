package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(250, TimeUnit.MILLISECONDS)

    Observable.combineLatest(observable1,observable2, BiFunction { t1:Long, t2:Long -> "t1: $t1, t2: $t2" })
              .subscribe{ println("Received $it") }

    runBlocking { delay(1100) }
}

//Received t1: 1, t2: 0
//Received t1: 2, t2: 0
//Received t1: 3, t2: 0
//Received t1: 3, t2: 1
//Received t1: 4, t2: 1
//Received t1: 5, t2: 1
//Received t1: 6, t2: 1
//Received t1: 6, t2: 2
//Received t1: 7, t2: 2
//Received t1: 8, t2: 2
//Received t1: 9, t2: 2
//Received t1: 9, t2: 3
//Received t1: 10, t2: 3