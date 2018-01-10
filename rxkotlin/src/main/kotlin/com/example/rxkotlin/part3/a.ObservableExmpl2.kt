package com.rivuchk.packtpub.reactivekotlin.chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

/**
 * Created by AU on 1/10/2018.
 */

fun main(args: Array<String>) {

    val observer: Observer<Any> = object :Observer<Any>{//1
        override fun onComplete() = println("All Completed") //2
        override fun onNext(item: Any) = println("Next $item") //3
        override fun onError(e: Throwable) = println("Error Occured $e") //4
        override fun onSubscribe(d: Disposable) = println("Subscribed to $d") //5
    }

    val observable: Observable<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable() //6

    observable.subscribe(observer)//7


    println("------------------------------------------------------")
    val observableOnList: Observable<List<Any>> = Observable.just(
            listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f),
            listOf("List with Single Item"),
            listOf(1,2,3,4,5,6)
    ) //8

    observableOnList.subscribe(observer)//9
}

//Subscribed to io.reactivex.internal.operators.observable.ObservableFromIterable$FromIterableDisposable@14bf9759
//Next One
//Next 2
//Next Three
//Next Four
//Next 4.5
//Next Five
//Next 6.0
//All Completed
//------------------------------------------------------
//Subscribed to io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable@7085bdee
//Next [One, 2, Three, Four, 4.5, Five, 6.0]
//Next [List with Single Item]
//Next [1, 2, 3, 4, 5, 6]
//All Completed