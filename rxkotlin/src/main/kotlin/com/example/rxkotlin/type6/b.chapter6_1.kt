package com.example.rxkotlin.type6

import io.reactivex.Observable

fun main(args: Array<String>) {
    println("startWith Iterator -----------------------")
    Observable.range(5,10)
              .startWith(listOf(1,2,3,4))//(1)
              .subscribe { println("Received $it") }

    println("startWith another source Producer  -----------------------")
    Observable.range(5,10)
              .startWith(Observable.just(1,2,3,4))//(2)
              .subscribe { println("Received $it") }
}

//startWith Iterator -----------------------
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Received 10
//Received 11
//Received 12
//Received 13
//Received 14
//startWith another source Producer  -----------------------
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Received 10
//Received 11
//Received 12
//Received 13
//Received 14
