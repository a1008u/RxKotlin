package com.example.rxkotlin.type6

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10,9,8,7,6,5,4,3,2,1).toObservable()
    observable.map { number-> "Transforming Int to String $number" }
              .subscribe { item-> println("Received $item") }
}

//Received Transforming Int to String 10
//Received Transforming Int to String 9
//Received Transforming Int to String 8
//Received Transforming Int to String 7
//Received Transforming Int to String 6
//Received Transforming Int to String 5
//Received Transforming Int to String 4
//Received Transforming Int to String 3
//Received Transforming Int to String 2
//Received Transforming Int to String 1