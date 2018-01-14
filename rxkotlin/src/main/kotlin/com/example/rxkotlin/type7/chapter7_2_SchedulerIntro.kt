package com.example.rxkotlin.type7

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

// concurrently
// subscribeOn(Schedulers.computation())
fun main(args: Array<String>) {
    Observable.range(1, 10)
              .subscribeOn(Schedulers.computation())//(1)
              .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
              }

    Observable.range(21, 10)
              .subscribeOn(Schedulers.computation())//(2)
              .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
              }

    runBlocking { delay(2100) }//(3)
}

//Observable2 Item Received 21
//Observable1 Item Received 1
//Observable2 Item Received 22
//Observable2 Item Received 23
//Observable1 Item Received 2
//Observable2 Item Received 24
//Observable2 Item Received 25
//Observable1 Item Received 3
//Observable2 Item Received 26
//Observable2 Item Received 27
//Observable1 Item Received 4
//Observable2 Item Received 28
//Observable2 Item Received 29
//Observable1 Item Received 5
//Observable2 Item Received 30
//Observable1 Item Received 6
//Observable1 Item Received 7
//Observable1 Item Received 8
//Observable1 Item Received 9
//Observable1 Item Received 10