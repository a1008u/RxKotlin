package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observable = Observable.range(1,20)
    observable
            .takeWhile{item->item<10}//(1)
            .subscribe(object: Observer<Int> {
                override fun onError(e: Throwable) = println("Error $e")
                override fun onComplete() = println("Complete")
                override fun onNext(t: Int) = println("Received $t")
                override fun onSubscribe(d: Disposable) = println("starting skipWhile")

            })
}

//starting skipWhile
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Complete