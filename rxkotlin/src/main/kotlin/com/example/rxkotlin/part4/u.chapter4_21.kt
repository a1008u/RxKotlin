package com.example.rxkotlin.part4

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Subscriber
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)

    //(2) x秒間(bufferメソッドの第1引数で秒数を決める。第2引数で単位を決める)に処理を行うことを決める
    flowable.buffer(1,TimeUnit.SECONDS)
            .subscribe { println(it) }

    // 出力数を決める（1秒間にバッファリングしてリストとして出力）
    runBlocking { delay(5, TimeUnit.SECONDS) }//(3)
}


//[0, 1, 2, 3, 4, 5, 6, 7, 8]
//[9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
//[19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
//[30, 31, 32, 33, 34, 35, 36, 37, 38, 39]
//[40, 41, 42, 43, 44, 45, 46, 47, 48]