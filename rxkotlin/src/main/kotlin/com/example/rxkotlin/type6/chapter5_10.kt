package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observable = Observable.range(1,20)
    observable
            .skipWhile {item->item<10}//(1)
            .subscribe(object: Observer<Int> {
                override fun onError(e: Throwable) = println("Error $e")
                override fun onComplete() = println("Complete")
                override fun onNext(t: Int) = println("Received $t")
                override fun onSubscribe(d: Disposable) = println("starting skipWhile")
            })
}

//starting skipWhile
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