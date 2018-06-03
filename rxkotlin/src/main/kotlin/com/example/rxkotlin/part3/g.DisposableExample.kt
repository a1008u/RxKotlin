package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 *
 * subscribeの実行を終了させる
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {
    runBlocking {
        val observale:Observable<Long> = Observable.interval(100,TimeUnit.MILLISECONDS)//1

        val observer:Observer<Long> = object : Observer<Long> {

            lateinit var disposable:Disposable//2

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }//3

            override fun onNext(item: Long) {
                println("Received $item")
                if(item>=10 && !disposable.isDisposed) {//4
                    disposable.dispose()//5
                    println("Disposed $item")
                }
            }

            override fun onError(e: Throwable) = println("Error ${e.message}")
            override fun onComplete() = println("Complete")

        }

        observale.subscribe(observer)
        delay(1500)//6
        println("test")
    }
}

// delay(1500)の時
//Received 0
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Received 10
//Disposed 10

//delay(100)の時
//Received 0
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//test
