package com.example.rxkotlin.type5

import io.reactivex.Observable

fun main(args: Array<String>) {

    // no express
    Observable
        .range(0,10)//(1)
        .filter{it>15}//(2)
        .subscribe({ println("Received $it") })

    // Received 15
    Observable
        .range(0,10)//(1)
        .filter{it>15}//(2)
        .defaultIfEmpty(15)//(3)
        .subscribe({ println("Received $it") })
}

