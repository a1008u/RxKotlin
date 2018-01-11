package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {
    val subject = ReplaySubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)

    subject.subscribe(
        { println("S1 Received $it") } // onNext
        ,{it.printStackTrace() }       // onError
        ,{println("S1 Complete") }     // onComplete
    )

    println("-----------------------------")

    subject.onNext(5)

    subject.subscribe(
        { println("S2 Received $it") } // onNext
        ,{ it.printStackTrace() }      // onError
        ,{ println("S2 Complete") }    // onComplete
    )

    subject.onComplete()
}

//S1 Received 1
//S1 Received 2
//S1 Received 3
//S1 Received 4
//-----------------------------
//S1 Received 5
//S2 Received 1
//S2 Received 2
//S2 Received 3
//S2 Received 4
//S2 Received 5
//S1 Complete
//S2 Complete