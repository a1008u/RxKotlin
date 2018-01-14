package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import io.reactivex.rxkotlin.zipWith

fun main(args: Array<String>) {
    val observable1 = Observable.range(1,10)
    val observable2 = listOf("String 1","String 2","String 3","String 4", "String 5"
                                                ,"String 6","String 7","String 8","String 9","String 10").toObservable()

    observable1.zipWith(observable2, {e1:Int,e2:String -> "$e2 $e1"})//(1)
               .subscribe { println("Received $it") }
}

//Received String 1 1
//Received String 2 2
//Received String 3 3
//Received String 4 4
//Received String 5 5
//Received String 6 6
//Received String 7 7
//Received String 8 8
//Received String 9 9
//Received String 10 10
