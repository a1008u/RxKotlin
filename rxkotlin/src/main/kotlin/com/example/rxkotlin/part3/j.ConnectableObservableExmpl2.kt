package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {
    val connectableObservable = Observable.interval(100,TimeUnit.MILLISECONDS).publish()//1
    connectableObservable.subscribe({ println("Subscription 1: $it") })//2
    connectableObservable.subscribe({ println("Subscription 2 $it")})//3
    connectableObservable.connect()//4
    runBlocking { delay(500) }//5

    println("------------")
    connectableObservable.subscribe({ println("Subscription 3: $it") })//6
    runBlocking { delay(500) }//7
}

//Subscription 1: 0
//Subscription 2 0
//Subscription 1: 1
//Subscription 2 1
//Subscription 1: 2
//Subscription 2 2
//Subscription 1: 3
//Subscription 2 3
//Subscription 1: 4
//Subscription 2 4
// ------------
//Subscription 1: 5
//Subscription 2 5
//Subscription 3: 5
//Subscription 1: 6
//Subscription 2 6
//Subscription 3: 6
//Subscription 1: 7
//Subscription 2 7
//Subscription 3: 7
//Subscription 1: 8
//Subscription 2 8
//Subscription 3: 8
//Subscription 1: 9
//Subscription 2 9
//Subscription 3: 9