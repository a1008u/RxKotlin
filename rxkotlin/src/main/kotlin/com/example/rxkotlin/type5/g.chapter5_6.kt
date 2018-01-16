package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = Observable.range(1,10)

    // first、lastメソッドの引数は、処理ができなかった際に渡されるitemを示す
    observable.first(2)//(1)
              .subscribeBy { item -> println("Received $item") }

    observable.last(2)//(2)
              .subscribeBy { item -> println("Received $item") }

    // Observableがemptyのためfirstの引数を出力
    Observable.empty<Int>().first(2)//(3)
              .subscribeBy { item -> println("Received $item") }
}

//Received 1
//Received 10
//Received 2