package com.example.rxkotlin.type7

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main(args: Array<String>) {

    // ThreadPoolを指定する。
    val executor:Executor = Executors.newFixedThreadPool(2)//(1)
    val scheduler:Scheduler = Schedulers.from(executor)//(2)

    Observable.range(1, 10)
              .subscribeOn(scheduler)//(3)
              .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it - ${Thread.currentThread().name}")
              }

    Observable.range(21, 10)
              .subscribeOn(scheduler)//(4)
              .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it - ${Thread.currentThread().name}")
              }


    // 先に終わったThreadPoolを利用する
    Observable.range(51, 10)
              .subscribeOn(scheduler)//(4)
              .subscribe {
                runBlocking { delay(100) }
                println("Observable3 Item Received $it - ${Thread.currentThread().name}")
              }

    runBlocking { delay(10000) }//(5)
}

//Observable2 Item Received 21 - pool-1-thread-2
//Observable2 Item Received 22 - pool-1-thread-2
//Observable1 Item Received 1 - pool-1-thread-1
//Observable2 Item Received 23 - pool-1-thread-2
//Observable1 Item Received 2 - pool-1-thread-1
//Observable2 Item Received 24 - pool-1-thread-2
//Observable2 Item Received 25 - pool-1-thread-2
//Observable1 Item Received 3 - pool-1-thread-1
//Observable2 Item Received 26 - pool-1-thread-2
//Observable2 Item Received 27 - pool-1-thread-2
//Observable1 Item Received 4 - pool-1-thread-1
//Observable2 Item Received 28 - pool-1-thread-2
//Observable2 Item Received 29 - pool-1-thread-2
//Observable1 Item Received 5 - pool-1-thread-1
//Observable2 Item Received 30 - pool-1-thread-2
//Observable3 Item Received 51 - pool-1-thread-2
//Observable1 Item Received 6 - pool-1-thread-1
//Observable3 Item Received 52 - pool-1-thread-2
//Observable3 Item Received 53 - pool-1-thread-2
//Observable1 Item Received 7 - pool-1-thread-1
//Observable3 Item Received 54 - pool-1-thread-2
//Observable3 Item Received 55 - pool-1-thread-2
//Observable1 Item Received 8 - pool-1-thread-1
//Observable3 Item Received 56 - pool-1-thread-2
//Observable3 Item Received 57 - pool-1-thread-2
//Observable1 Item Received 9 - pool-1-thread-1
//Observable3 Item Received 58 - pool-1-thread-2
//Observable3 Item Received 59 - pool-1-thread-2
//Observable1 Item Received 10 - pool-1-thread-1
//Observable3 Item Received 60 - pool-1-thread-2