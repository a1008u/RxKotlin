package com.example.rxkotlin.type7

import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.range(1,10)
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
            }

    println("----------------------------")

    Observable.range(21,10)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
            }
}

//The total execution time of this program would be around 3,100 milliseconds

//Observable1 Item Received 1
//Observable1 Item Received 2
//Observable1 Item Received 3
//Observable1 Item Received 4
//Observable1 Item Received 5
//Observable1 Item Received 6
//Observable1 Item Received 7
//Observable1 Item Received 8
//Observable1 Item Received 9
//Observable1 Item Received 10
//----------------------------
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