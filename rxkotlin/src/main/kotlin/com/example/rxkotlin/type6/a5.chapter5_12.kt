package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit


/**
 * takeメソッドは引数に指定したデータ数や期間に達するまで、受け取ったデータを通知するオペレータです。
 * 指定したデータ数や期間に達したら、完了を通知して処理を終了します。
 * もし、指定した範囲が元の生産者が通知するデータ数より多い場合、元のデータをすべて通知して、完了します。
 */
fun main(args: Array<String>) {
    val observable1 = Observable.range(1,20)
    observable1
            .take(5)//(1)
            .subscribe(object:Observer<Int> {
                override fun onError(e: Throwable) = println("Error $e")
                override fun onComplete() = println("Complete")
                override fun onNext(t: Int) = println("Received $t")
                override fun onSubscribe(d: Disposable) = println("starting skip(count)")
            })

    val observable2 = Observable.interval(100,TimeUnit.MILLISECONDS)
    observable2
            .take(400,TimeUnit.MILLISECONDS)//(2)
            .subscribe(
                    object:Observer<Long> {
                        override fun onError(e: Throwable) = println("Error $e")
                        override fun onComplete() = println("Complete")
                        override fun onNext(t: Long) = println("Received $t")
                        override fun onSubscribe(d: Disposable) = println("starting skip(time)")
                    }
            )

    runBlocking {
        delay(1000)
    }

}

//starting skip(count)
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Complete
//starting skip(time)
//Received 0
//Received 1
//Received 2
//Received 3
//Complete