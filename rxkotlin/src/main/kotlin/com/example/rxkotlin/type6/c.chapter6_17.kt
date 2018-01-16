package com.example.rxkotlin.type6

import io.reactivex.Observable

// onErrorReturn -return a default value on error-
fun main(args: Array<String>) {
    Observable.just(1,2,3,4,5)
              .map { it/(3-it) }
              .onErrorReturn { -1 }//(1)
              .subscribe { println("Received $it") }
}


//Received 0
//Received 2
//Received -1
