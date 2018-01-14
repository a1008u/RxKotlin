package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9)//(1)
    val subject = BehaviorSubject.create<Int>()

    //(2) (3) (4)
    subject.observeOn(Schedulers.computation())
           .subscribe({
                println("Subs 1 Received $it")
                runBlocking { delay(200) }
            })

    //(5) (6)
    subject.observeOn(Schedulers.computation())
           .subscribe({ println("Subs 2 Received $it") })

    //(7)
    observable.subscribe(subject)

    //(8)
    runBlocking { delay(2000) }
}


//Subs 1 Received 1
//Subs 2 Received 1
//Subs 2 Received 2
//Subs 2 Received 3
//Subs 2 Received 4
//Subs 2 Received 5
//Subs 2 Received 6
//Subs 2 Received 7
//Subs 2 Received 8
//Subs 2 Received 9
//Subs 1 Received 2
//Subs 1 Received 3
//Subs 1 Received 4
//Subs 1 Received 5
//Subs 1 Received 6
//Subs 1 Received 7
//Subs 1 Received 8
//Subs 1 Received 9