package com.example.rxkotlin.type7

import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    listOf("1","2","3","4","5","6","7","8","9","10")
            .toObservable()
            .observeOn(Schedulers.computation())//(1)
            .map {
                item-> println("Mapping $item - ${Thread.currentThread().name}")
                return@map item.toInt()
            }
            .observeOn(Schedulers.io())//(2)
            .subscribe {
                item -> println("Received $item - ${Thread.currentThread().name}")
            }

    runBlocking { delay(1000) }
}

//Mapping 1 - RxComputationThreadPool-1
//Mapping 2 - RxComputationThreadPool-1
//Mapping 3 - RxComputationThreadPool-1
//Mapping 4 - RxComputationThreadPool-1
//Received 1 - RxCachedThreadScheduler-1
//Mapping 5 - RxComputationThreadPool-1
//Received 2 - RxCachedThreadScheduler-1
//Mapping 6 - RxComputationThreadPool-1
//Received 3 - RxCachedThreadScheduler-1
//Mapping 7 - RxComputationThreadPool-1
//Received 4 - RxCachedThreadScheduler-1
//Mapping 8 - RxComputationThreadPool-1
//Received 5 - RxCachedThreadScheduler-1
//Received 6 - RxCachedThreadScheduler-1
//Received 7 - RxCachedThreadScheduler-1
//Received 8 - RxCachedThreadScheduler-1
//Mapping 9 - RxComputationThreadPool-1
//Mapping 10 - RxComputationThreadPool-1
//Received 9 - RxCachedThreadScheduler-1
//Received 10 - RxCachedThreadScheduler-1