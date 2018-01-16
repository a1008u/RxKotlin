package com.example.rxkotlin.type6

import io.reactivex.Observable

// The onErrorResumeNext operator helps you subscribe to a different producer in case any error occurs.
fun main(args: Array<String>) {
    Observable.just(1,2,3,4,5)
              .map { it/(3-it) }
              .onErrorResumeNext(Observable.range(10,5))//(1)
              .subscribe { println("Received $it") }
}

//Received 0
//Received 2
//Received 10
//Received 11
//Received 12
//Received 13
//Received 14