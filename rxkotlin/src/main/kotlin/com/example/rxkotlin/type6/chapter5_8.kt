package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    // skip(count:Long)
    val observable1 = Observable.range(1,20)
    observable1
            .skip(5)//(1)
            .subscribe(
                    object:Observer<Int> {
                        override fun onError(e: Throwable) = println("Error $e")
                        override fun onComplete() = println("Complete")
                        override fun onNext(t: Int) = println("Received $t")
                        override fun onSubscribe(d: Disposable) = println("starting skip(count)")
                    }
            )

    // skip(time:Long, unit:TimeUnit)
    val observable2 = Observable.interval(100,TimeUnit.MILLISECONDS)
    observable2
            .skip(400,TimeUnit.MILLISECONDS)//(2)
            .subscribe(
                    object:Observer<Long> {
                        override fun onError(e: Throwable) = println("Error $e")
                        override fun onComplete() = println("Complete")
                        override fun onNext(t: Long) = println("Received $t")
                        override fun onSubscribe(d: Disposable) = println("starting skip(time)")
                    }
            )

    runBlocking { delay(1000) }

}


//starting skip(count)
//Received 6
//Received 7
//Received 8
//Received 9
//Received 10
//Received 11
//Received 12
//Received 13
//Received 14
//Received 15
//Received 16
//Received 17
//Received 18
//Received 19
//Received 20
//Complete
//starting skip(time)
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9