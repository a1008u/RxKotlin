package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

/**
 * flatMapメソッド
 * mapメソッドのように元のデータを変換し、その変換したデータを通知するオペレータです。
 * しかし、flatMapメソッドではmapメソッドと異なり、
 * 受け取ったデータから複数のデータを持つFlowable／Observableを返すことで、
 * 1つのデータから複数のデータを通知することが可能になります。
 *
 * さらに、空のFlowable／Observableを返すことで特定のデータの通知を止めたり、
 * エラーのFlowable／Observableを返すことでエラーを通知したりすることが可能になります。
 */
fun main(args: Array<String>) {
    val observable = listOf(10,9,8,7,6,5,4,3,2,1).toObservable()

    // the flatMap operator creates a new producer(Observable)
    observable.flatMap { number-> Observable.just("Transforming Int to String $number") }
              .subscribe { item-> println("Received $item") }


    println("observable2の結果 -------------------------------------- ")

    val observable2 = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).toObservable()
    observable2.flatMap {
                //(1)
                number -> Observable.create<String> {
                                it.onNext("The Number $number")
                                it.onNext("number/2 ${number / 2}")
                                it.onNext("number%2 ${number % 2}")
                                it.onComplete()
                               }
                }
              .subscribeBy(
                  onNext = { item -> println("Received $item") }
                  , onComplete = { println("Complete") }
              )

}

//Received Transforming Int to String 10
//Received Transforming Int to String 9
//Received Transforming Int to String 8
//Received Transforming Int to String 7
//Received Transforming Int to String 6
//Received Transforming Int to String 5
//Received Transforming Int to String 4
//Received Transforming Int to String 3
//Received Transforming Int to String 2
//Received Transforming Int to String 1
//observable2の結果 --------------------------------------
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