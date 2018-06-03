package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.Callable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/10/2018.
 */

fun main(args: Array<String>) {

    val list2 = mutableListOf<String>()

    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() = println(list2.toString())
        override fun onNext(item: String) {
            println("Next $item")
            list2.add(item)
        }
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }//Create Observer

    val list = listOf("String 1","String 2","String 3","String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)//1
    observableFromIterable.subscribe(observer)

    println("-----------------------------")
    val callable = Callable<String> { "From Callable" }
    val observableFromCallable:Observable<String> = Observable.fromCallable(callable)//2
    observableFromCallable.subscribe(observer)

    println("-----------------------------")
    val future:Future<String> = object :Future<String> {
        override fun get(): String = "Hello From Future"
        override fun get(timeout: Long, unit: TimeUnit?): String  = "Hello From Future"
        override fun isDone(): Boolean = true
        override fun isCancelled(): Boolean = false
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

    }
    val observableFromFuture:Observable<String> = Observable.fromFuture(future)//3
    observableFromFuture.subscribe(observer)
}


//New Subscription
//Next String 1
//Next String 2
//Next String 3
//Next String 4
//All Completed
//-----------------------------
//New Subscription
//Next From Callable
//All Completed
//-----------------------------
//New Subscription
//Next Hello From Future
//All Completed
