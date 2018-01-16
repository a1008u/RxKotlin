package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {

    // Create Observer
    val observer: Observer<Int> = object : Observer<Int> {
        override fun onComplete() = println("All Completed")
        override fun onNext(item: Int) = println("Next $item")
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }

    val observable: Observable<Int> = Observable.create<Int> {//1
        for(i in 1..10) {
            it.onNext(i)
        }

        it.onComplete()
    }

    println("-------------")

    observable.subscribe(observer)

}

//-------------
//New Subscription
//Next 1
//Next 2
//Next 3
//Next 4
//Next 5
//Next 6
//Next 7
//Next 8
//Next 9
//Next 10
//All Completed