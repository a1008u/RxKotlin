package com.example.rxkotlin.part4

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)

    // throttleFirstメソッドでは最初のemissionをスキップして、次のemissionから
    flowable.throttleFirst(200,TimeUnit.MILLISECONDS)//(2)
            .subscribe { println(it) }

    runBlocking { delay(1,TimeUnit.SECONDS) }
}


//0
//3
//6
//9