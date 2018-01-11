package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {

    val observable: Observable<String> = listOf("String 1","String 2","String 3","String 4").toObservable()//1

    // 2
    observable.subscribe(
        { println("Received $it") }
        ,{ println("Error ${it.message}") }
        ,{ println("Done") }
    )

    println("---------------------------------")

    // 3
    observable.subscribe(
        { println("Received $it") }
        ,{ println("Error ${it.message}") }
        ,{ println("Done") }
    )

}

//Received String 1
//Received String 2
//Received String 3
//Received String 4
//Done
//---------------------------------
//Received String 1
//Received String 2
//Received String 3
//Received String 4
//Done