package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {

    // observableを作成
    val observable:Observable<Int> = Observable.range(1,5)//1

    //　2
    observable.subscribe(
        {println("Next $it")}             // onNext method
        ,{println("Error ${it.message}")} // onError Method
        ,{println("Done") })              // onComplete Method


    //　3
    val observer: Observer<Int> = object : Observer<Int> {
        override fun onComplete() = println("All Completed")
        override fun onNext(item: Int) = println("Next $item")
        override fun onError(e: Throwable) = println("Error Occurred ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }

    observable.subscribe(observer)

}

//Next 1
//Next 2
//Next 3
//Next 4
//Next 5
//Done
//New Subscription
//Next 1
//Next 2
//Next 3
//Next 4
//Next 5
//All Completed