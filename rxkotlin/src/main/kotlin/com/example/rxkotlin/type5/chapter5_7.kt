package com.example.rxkotlin.type5

import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.range(1,10)

    observable.ignoreElements()
             .subscribe { println("Completed") }//(1)
}

//「you may require to listen only on the onComplete of a producer」をしたい時に利用
//Completed