package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy


fun main(args: Array<String>) {
    Observable.just(1,2,3,5,6,7,"Errr",8,9,10)
              .map { it.toIntOrError() }
              .subscribeBy (
                    onNext = { println("Next $it") }
                    , onError = { println("Error $it") }
              )
}

//Next 1
//Next 2
//Next 3
//Next 5
//Next 6
//Next 7
//Error java.lang.NumberFormatException: For input string: "Errr"