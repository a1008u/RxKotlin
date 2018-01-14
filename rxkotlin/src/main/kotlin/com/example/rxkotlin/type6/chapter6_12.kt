package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val observable = Observable.range(1,30)

    observable.groupBy { it%5 }
              .blockingSubscribe {
                  println("Key ${it.key} ")
                  it.subscribe { println("Received $it") }
               }
}

//Key 1
//Received 1
//Received 6
//Received 11
//Received 16
//Received 21
//Received 26
//Key 2
//Received 2
//Received 7
//Received 12
//Received 17
//Received 22
//Received 27
//Key 3
//Received 3
//Received 8
//Received 13
//Received 18
//Received 23
//Received 28
//Key 4
//Received 4
//Received 9
//Received 14
//Received 19
//Received 24
//Received 29
//Key 0
//Received 5
//Received 10
//Received 15
//Received 20
//Received 25
//Received 30