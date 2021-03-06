package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable1 = listOf("Kotlin", "Scala", "Groovy").toObservable()
    val observable2 = listOf("Python", "Java", "C++", "C").toObservable()

    observable1.mergeWith(observable2)
               .subscribe { println("Received $it") }
}

//Received Kotlin
//Received Scala
//Received Groovy
//Received Python
//Received Java
//Received C++
//Received C