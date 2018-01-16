package com.example.rxkotlin.type5

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0,10)//(1)
            .filter{it>15}//(2)
            .switchIfEmpty(Observable.range(11,10))//(3)
            .subscribe({ println("Received $it") })
}

//Received 11
//Received 12
//Received 13
//Received 14
//Received 15
//Received 16
//Received 17
//Received 18
//Received 19
//Received 20