package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
 */

/**
 * Subject
 * 「SubscriberとObservableの2つの機能を併せ持ったもの」です。
 * SubscriberにあるようなonNextやonError、onCompleteといったメソッドを呼び出せ、
 * Observableのようにsubscribeメソッドを呼び出すことができます。
 */
fun main(args: Array<String>) {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)//1
    val subject = PublishSubject.create<Long>()//2

    //3
    observable.subscribe(subject)

    //4
    subject
        .doOnNext({ println("do Received $it") })
        .subscribe({ println("Received $it") })
    //subject.subscribe({ println("Received $it") })

    //5
    runBlocking { delay(1100) }
}

//Received 0
//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Received 10
