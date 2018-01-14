package com.example.rxkotlin.type7

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun main(args: Array<String>) {

    async(CommonPool) {
        Observable.range(1, 10)
                  .subscribeOn(Schedulers.single())//(1)
                  .subscribe {
                    runBlocking { delay(200) }
                    println("Observable1 Item Received $it")
                  }

        Observable.range(21, 10)
                  .subscribeOn(Schedulers.single())//(2)
                  .subscribe {
                    runBlocking { delay(100) }
                    println("Observable2 Item Received $it")
                  }

        for (i in 1..10) {
            delay(100)
            println("Blocking Thread $i")
        }
    }

    runBlocking { delay(6000) }
}

//Blocking Thread 1
//Observable1 Item Received 1
//Blocking Thread 2
//Blocking Thread 3
//Observable1 Item Received 2
//Blocking Thread 4
//Blocking Thread 5
//Observable1 Item Received 3
//Blocking Thread 6
//Blocking Thread 7
//Observable1 Item Received 4
//Blocking Thread 8
//Blocking Thread 9
//Observable1 Item Received 5
//Blocking Thread 10
//Observable1 Item Received 6
//Observable1 Item Received 7
//Observable1 Item Received 8
//Observable1 Item Received 9
//Observable1 Item Received 10
//Observable2 Item Received 21
//Observable2 Item Received 22
//Observable2 Item Received 23
//Observable2 Item Received 24
//Observable2 Item Received 25
//Observable2 Item Received 26
//Observable2 Item Received 27
//Observable2 Item Received 28
//Observable2 Item Received 29
//Observable2 Item Received 30