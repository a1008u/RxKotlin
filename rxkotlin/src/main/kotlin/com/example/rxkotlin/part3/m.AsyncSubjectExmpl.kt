package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6321)//1
    val subject = AsyncSubject.create<Int>()//2

    //3
    observable.subscribe(subject)

    //4
    subject.subscribe(
            { println("Received $it") } //onNext
            ,{ it.printStackTrace() } //onError
            ,{ println("Complete") } //onComplete
    )

    //5
    subject.onNext(2)

    //6
    subject.onComplete()
}

//Received 6321
//Complete