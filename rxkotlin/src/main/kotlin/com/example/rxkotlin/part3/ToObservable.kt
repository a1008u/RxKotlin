package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable


/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {

    //Create Observer
    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() =println("All Completed")
        override fun onNext(item: String) =println("Next $item")
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }

    val list:List<String> = listOf("String 1","String 2","String 3","String 4")

    val observable:Observable<String> = list.toObservable()

    observable.subscribe(observer)
}

//New Subscription
//Next String 1
//Next String 2
//Next String 3
//Next String 4
//All Completed