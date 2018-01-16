package com.example.rxkotlin.type6

import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    //(1)(2)
    val observable1 = Observable.interval(500, TimeUnit.MILLISECONDS).take(2).map { "Observable 1 $it" }
    //(3)
    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS).map { "Observable 2 $it" }

    // mergeとは違い、順序を重視する（observable1と2が逆だとobservable1は実行しない）
    Observable.concat(observable1, observable2)
              .subscribe { println("Received $it") }

    runBlocking { delay(1500) }
}

//Received Observable 1 0
//Received Observable 1 1
//Received Observable 2 0
//Received Observable 2 1
//Received Observable 2 2
//Received Observable 2 3
//Received Observable 2 4