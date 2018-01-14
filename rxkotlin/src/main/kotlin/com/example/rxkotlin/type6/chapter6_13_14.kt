package com.example.rxkotlin.type6

import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.range(1,10)
            .flatMap {
                val randDelay = Random().nextInt(10)
                return@flatMap Observable.just(it).delay(randDelay.toLong(),TimeUnit.MILLISECONDS)//(1)
            }
            .blockingSubscribe { println("Received $it") }

    println("-----------------")

    Observable.range(1,10)
            .concatMap {
                val randDelay = Random().nextInt(10)
                return@concatMap Observable.just(it).delay(randDelay.toLong(), TimeUnit.MILLISECONDS)//(1)
            }
            .blockingSubscribe { println("Received $it") }
}

//Received 5
//Received 4
//Received 7
//Received 9
//Received 10
//Received 1
//Received 8
//Received 2
//Received 3
//Received 6
//-----------------
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
