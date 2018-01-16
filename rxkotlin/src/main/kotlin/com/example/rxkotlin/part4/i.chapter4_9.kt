package com.example.rxkotlin.part4

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args: Array<String>) {

    val subscriber: Subscriber<Int> = object : Subscriber<Int> {
        override fun onComplete() = println("All Completed")
        override fun onNext(item: Int) = println("Next $item")
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(subscription: Subscription) {
            println("New Subscription ")
            subscription.request(10)
            println("++++++++++++++++++++")
        }
    }//(1)

    val flowable: Flowable<Int> = Flowable.create<Int> ({//1
        for(i in 1..20) {
            it.onNext(i)
        }
        it.onComplete()
    }, BackpressureStrategy.BUFFER)//(2)

    flowable.observeOn(Schedulers.io())
            .subscribe(subscriber)//(3)

    println("-------------------------")

    runBlocking {
        println("=========================")
        delay(10)
    }

    println("-------------------------")

}

//New Subscription
//++++++++++++++++++++
//-------------------------
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
//=========================
//-------------------------



