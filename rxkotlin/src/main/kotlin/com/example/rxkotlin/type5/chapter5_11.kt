package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    Observable.range(0,10)//(1)
            .startWith(-1)//(2)
            .subscribe({ println("Received $it") })

    println("-----------------------------")

    listOf("C","C++","Java","Kotlin","Scala","Groovy")//(3)
            .toObservable()
            .startWith("Programming Languages")//(4)
            .subscribe({ println("Received $it") })
}

//Received -1
//Received 0
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//-----------------------------
//Received Programming Languages
//Received C
//Received C++
//Received Java
//Received Kotlin
//Received Scala
//Received Groovy