package com.example.rxkotlin.type5

import io.reactivex.Observable


fun main(args: Array<String>) {

    // filter emissions
    Observable.range(1,20)
            .filter{ it%2==0 }
            .subscribe { println("Received $it") }
}

//Received 2
//Received 4
//Received 6
//Received 8
//Received 10
//Received 12
//Received 14
//Received 16
//Received 18
//Received 20