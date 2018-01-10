package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy


/**
 * Created by AU on 1/10/2018.
 */

fun main(args: Array<String>) {

    val observer: Observer<String> = object : Observer<String> {

        override fun onComplete() = println("All Completed") //2
        override fun onNext(item: String) = println("Next $item") //3
        override fun onError(e: Throwable) =  println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) =  println("New Subscription ")

    }//Create Observer

    val observable:Observable<String> = Observable.create<String> {//1
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }
    observable.subscribe(observer)

    println("------------------------------------------------")

    val observable2:Observable<String> = Observable.create<String> {//2
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Exception"))
    }
    observable2.subscribe(observer)
}

//New Subscription
//Next Emit 1
//Next Emit 2
//Next Emit 3
//Next Emit 4
//All Completed
//------------------------------------------------
//New Subscription
//Next Emit 1
//Next Emit 2
//Next Emit 3
//Next Emit 4
//Error Occured My Custom Exception