package com.example.rxkotlin.part3

import io.reactivex.rxkotlin.toObservable

/**
 * Created by AU on 1/11/2018.
 */

fun main(args: Array<String>) {
    //1
    val connectableObservable = listOf("String 1","String 2","String 3","String 4","String 5").toObservable().publish()

    // 2
    connectableObservable.subscribe({ println("Subscription 1: $it") })

    // 3 4
    connectableObservable.map(String::reversed)
                         .subscribe({ println("Subscription 2 $it")})

    // 5 これ以降は実施しない
    connectableObservable.connect()

    //6 Will never get called
    connectableObservable.subscribe({ println("Subscription 3: $it") })
}

// これはhot Observaleobjectの例
//Subscription 1: String 1
//Subscription 2 1 gnirtS
//Subscription 1: String 2
//Subscription 2 2 gnirtS
//Subscription 1: String 3
//Subscription 2 3 gnirtS
//Subscription 1: String 4
//Subscription 2 4 gnirtS
//Subscription 1: String 5
//Subscription 2 5 gnirtS
