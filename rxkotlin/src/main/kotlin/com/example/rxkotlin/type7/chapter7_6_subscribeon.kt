package com.example.rxkotlin.type7

import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    listOf("1","2","3","4","5","6","7","8","9","10")
            .toObservable()
            .map {
                item-> println("Mapping $item - ${Thread.currentThread().name}")
                return@map item.toInt()
            }
            .subscribe {
                item -> println("Received $item - ${Thread.currentThread().name}")
            }

    runBlocking { delay(1000) }
}

//Mapping 1 - main
//Received 1 - main
//Mapping 2 - main
//Received 2 - main
//Mapping 3 - main
//Received 3 - main
//Mapping 4 - main
//Received 4 - main
//Mapping 5 - main
//Received 5 - main
//Mapping 6 - main
//Received 6 - main
//Mapping 7 - main
//Received 7 - main
//Mapping 8 - main
//Received 8 - main
//Mapping 9 - main
//Received 9 - main
//Mapping 10 - main
//Received 10 - main