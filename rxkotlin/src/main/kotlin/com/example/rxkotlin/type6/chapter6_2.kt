package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.functions.BiFunction

fun main(args: Array<String>) {
    val observable1 = Observable.range(1,10)
    val observable2 = Observable.range(11,10)

    Observable.zip(observable1
                    , observable2
                    , BiFunction<Int, Int, Int> { emissionO1, emissionO2 -> emissionO1 + emissionO2 })
              .subscribe { println("Received $it") }
}


//Received 12
//Received 14
//Received 16
//Received 18
//Received 20
//Received 22
//Received 24
//Received 26
//Received 28
//Received 30