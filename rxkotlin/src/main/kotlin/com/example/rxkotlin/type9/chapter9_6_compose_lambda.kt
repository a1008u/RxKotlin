package com.example.rxkotlin.type9

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.range(1,10)
              .compose<List<Int>> { upstream: Observable<Int> -> upstream.toList().toObservable() }
              .first(listOf())
              .subscribeBy { println(it) }
}

// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]