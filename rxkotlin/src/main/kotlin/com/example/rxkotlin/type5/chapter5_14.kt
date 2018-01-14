package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    Observable.range(1,10)
              .scan { previousAccumulation, newEmission ->  previousAccumulation + newEmission }//(1)
              .subscribe { println("Received $it") }

    println("-------------------")

    listOf("String 1","String 2", "String 3", "String 4")
            .toObservable()
            .scan{ previousAccumulation, newEmission ->  previousAccumulation + " " + newEmission }//(2)
            .subscribe { println("Received $it") }

    println("-------------------")

    Observable.range(1,5)
              .scan { previousAccumulation, newEmission ->  previousAccumulation * 10 + newEmission }//(3)
              .subscribe { println("Received $it") }

}

//Received 1
//Received 3
//Received 6
//Received 10
//Received 15
//Received 21
//Received 28
//Received 36
//Received 45
//Received 55
//-------------------
//Received String 1
//Received String 1 String 2
//Received String 1 String 2 String 3
//Received String 1 String 2 String 3 String 4
//-------------------
//Received 1
//Received 12
//Received 123
//Received 1234
//Received 12345