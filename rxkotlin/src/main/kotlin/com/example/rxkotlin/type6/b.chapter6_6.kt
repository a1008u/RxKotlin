package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

/**
 * mergeメソッドは複数のFlowable／Observableが通知するデータを1つのFlowable／Observableを通して通知するオペレータです。
 * このメソッドを使うことで、複数のFlowable／Observableの通知を1つのSubscriber／Observerに購読させることができるようになります。
 *
 * error
 * 引数のFlowable／Observableのどれかがエラーを通知したら、そのタイミングでエラーを通知し処理が終了します。
 * もし、エラーの通知を保留して他の正常なFlowable／Observableを処理してから最後にエラーを通知したい場合は、mergeDelayErrorメソッドを使用する。
 */
fun main(args: Array<String>) {
    val observable1 = listOf("Kotlin", "Scala", "Groovy").toObservable()
    val observable2 = listOf("Python", "Java", "C++", "C").toObservable()

    Observable.merge(observable1, observable2)//(1)
              .subscribe { println("Received $it") }
}

//Received Kotlin
//Received Scala
//Received Groovy
//Received Python
//Received Java
//Received C++
//Received C