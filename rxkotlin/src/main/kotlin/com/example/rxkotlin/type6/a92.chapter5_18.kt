package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10,9,8,7,6,5,4,3,2,1).toObservable()
    observable.switchMap { number-> Observable.create<String> {//(1)
                                            it.onNext("The Number $number")//(2)
                                            it.onNext("number/2 ${number/2}")//(3)
                                            it.onNext("number%2 ${number%2}")//(4)
                                            it.onComplete()//(5)
                                          }
                         }
               .subscribeBy (
                onNext = { item-> println("Received $item") }
                , onComplete = { println("Complete") }
               )
}

//Received The Number 10
//Received number/2 5
//Received number%2 0
//Received The Number 9
//Received number/2 4
//Received number%2 1
//Received The Number 8
//Received number/2 4
//Received number%2 0
//Received The Number 7
//Received number/2 3
//Received number%2 1
//Received The Number 6
//Received number/2 3
//Received number%2 0
//Received The Number 5
//Received number/2 2
//Received number%2 1
//Received The Number 4
//Received number/2 2
//Received number%2 0
//Received The Number 3
//Received number/2 1
//Received number%2 1
//Received The Number 2
//Received number/2 1
//Received number%2 0
//Received The Number 1
//Received number/2 0
//Received number%2 1
//Complete