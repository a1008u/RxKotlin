package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observable = Observable.range(1,20)
    observable
            .skipLast(5)//(1)
            .subscribe(object: Observer<Int> {
                override fun onError(e: Throwable) = println("Error $e")
                override fun onComplete() = println("Complete")
                override fun onNext(t: Int) = println("Received $t")
                override fun onSubscribe(d: Disposable) = println("starting skipLast(count)")

            })
}

//starting skipLast(count)
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
//Received 11
//Received 12
//Received 13
//Received 14
//Received 15
//Complete