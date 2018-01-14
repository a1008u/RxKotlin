package com.example.rxkotlin.type5

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    listOf(1,2,2,3,4,5,5,5,6,7,8,9,3,10)//(1)
            .toObservable()//(2)
            .distinctUntilChanged()//(3) 連続し重複した要素のみを排除する
            .subscribe { println("Received $it") }//(4)
}

//Received 1
//Received 2
//Received 3
//Received 4
//Received 5
//Received 6
//Received 7
//Received 8
//Received 9
//Received 3
//Received 10