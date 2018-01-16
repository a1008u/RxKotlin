package com.example.rxkotlin.type6

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    println("Without delay --------------------------------------")
    Observable.range(1,10)
            .switchMap {
                val randDelay = Random().nextInt(10)
                return@switchMap Observable.just(it)//(1)
            }
            .blockingSubscribe {
                println("Received $it")
            }


    println("With delay --------------------------------------")
    Observable.range(1,10)
            .switchMap {
                val randDelay = Random().nextInt(10)
                return@switchMap Observable.just(it).delay(randDelay.toLong(), TimeUnit.MILLISECONDS)//(2)
            }
            .blockingSubscribe {
                println("Received $it")
            }
}

//Without delay --------------------------------------
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
//With delay --------------------------------------
//Received 10