package com.example.rxkotlin.part4

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Subscriber
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val boundaryFlowable = Flowable.interval(350, TimeUnit.MILLISECONDS)

    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)

    flowable.buffer(boundaryFlowable)//(2)
            .subscribe { println(it) }

    runBlocking { delay(5, TimeUnit.SECONDS) }//(3)

}

//５秒間の内で0.1秒の処理を0.35秒間に行った文をListとしてprintする
//[0, 1, 2]
//[3, 4, 5, 6]
//[7, 8, 9]
//[10, 11, 12]
//[13, 14, 15, 16]
//[17, 18, 19]
//[20, 21, 22, 23]
//[24, 25, 26]
//[27, 28, 29, 30]
//[31, 32, 33]
//[34, 35, 36, 37]
//[38, 39, 40, 41]
//[42, 43, 44]
//[45, 46, 47, 48]
