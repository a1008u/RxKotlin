package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by AU on 1/10/2018.
 */

fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() = println("All Completed")
        override fun onNext(item: Any) = println("Next $item")
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }//Create Observer

    Observable.just("A String").subscribe(observer)
    println("-------------------------------")
    Observable.just(54).subscribe(observer)
    println("-------------------------------")
    Observable.just(listOf("String 1","String 2","String 3","String 4")).subscribe(observer)
    println("-------------------------------")
    Observable.just(mapOf(Pair("Key 1","Value 1"),Pair("Key 2","Value 2"),Pair("Key 3","Value 3"))).subscribe(observer)
    println("-------------------------------")
    Observable.just(arrayListOf(1,2,3,4,5,6)).subscribe(observer)
    println("-------------------------------")
    Observable.just("String 1","String 2","String 3").subscribe(observer)//1
}

//New Subscription
//Next A String
//All Completed
//-------------------------------
//New Subscription
//Next 54
//All Completed
//-------------------------------
//New Subscription
//Next [String 1, String 2, String 3, String 4]
//All Completed
//-------------------------------
//New Subscription
//Next {Key 1=Value 1, Key 2=Value 2, Key 3=Value 3}
//All Completed
//-------------------------------
//New Subscription
//Next [1, 2, 3, 4, 5, 6]
//All Completed
//-------------------------------
//New Subscription
//Next String 1
//Next String 2
//Next String 3
//All Completed