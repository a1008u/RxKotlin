package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
*/

fun main(args: Array<String>) {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)//1
    val subject = PublishSubject.create<Long>()//2

    //3
    observable.subscribe(subject)

    //4
    subject.subscribe({ println("Subscription 1 Received $it") })

    //5
    runBlocking { delay(1100) }

    println("--------------------")

    //6
    subject.subscribe({ println("Subscription 2 Received $it") })

    //7
    runBlocking { delay(1100) }
}

// Cold ObservableをHot Oberservaleに変える
//Subscription 1 Received 0
//Subscription 1 Received 1
//Subscription 1 Received 2
//Subscription 1 Received 3
//Subscription 1 Received 4
//Subscription 1 Received 5
//Subscription 1 Received 6
//Subscription 1 Received 7
//Subscription 1 Received 8
//Subscription 1 Received 9
//Subscription 1 Received 10
//--------------------
//Subscription 1 Received 11
//Subscription 2 Received 11
//Subscription 1 Received 12
//Subscription 2 Received 12
//Subscription 1 Received 13
//Subscription 2 Received 13
//Subscription 1 Received 14
//Subscription 2 Received 14
//Subscription 1 Received 15
//Subscription 2 Received 15
//Subscription 1 Received 16
//Subscription 2 Received 16
//Subscription 1 Received 17
//Subscription 2 Received 17
//Subscription 1 Received 18
//Subscription 2 Received 18
//Subscription 1 Received 19
//Subscription 2 Received 19
//Subscription 1 Received 20
//Subscription 2 Received 20
//Subscription 1 Received 21
//Subscription 2 Received 21