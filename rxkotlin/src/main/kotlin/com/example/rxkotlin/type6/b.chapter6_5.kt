package com.example.rxkotlin.type6

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

/**
 * combineLatestメソッド
 * 複数のFlowable／Observableが通知するそれぞれのデータを引数の関数型インターフェースに渡すことで新たなデータを生成して通知するオペレータです。
 * 通知のタイミングは最初のデータのみ各Flowable／Observableがデータを通知するのを待って、
 * それ以降は各Flowable／Observableがデータを通知するたびに、
 * それまでに通知している最新のデータを使って新しいデータを生成していきます。
 * 完了を通知するタイミングは、全ての引数のFlowable／Observableが完了を通知したタイミングで完了するようになります。
 *
 * 引数には結合するFlowable／Observableの他に、
 * それぞれの受け取ったデータをどのように変換し新しいデータを生成するのかを定義する関数型インターフェースを持っています。
 * この関数型インターフェースは受け取るFlowable／Observableの数によって、BiFunction、Function3、Function4、……と変わっていきます。
 */
fun main(args: Array<String>) {
    val observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(250, TimeUnit.MILLISECONDS)

    Observable.combineLatest(observable1,observable2, BiFunction { t1:Long, t2:Long -> "t1: $t1, t2: $t2" })
              .subscribe{ println("Received $it") }

    runBlocking { delay(1100) }
}

//Received t1: 1, t2: 0
//Received t1: 2, t2: 0
//Received t1: 3, t2: 0
//Received t1: 3, t2: 1
//Received t1: 4, t2: 1
//Received t1: 5, t2: 1
//Received t1: 6, t2: 1
//Received t1: 6, t2: 2
//Received t1: 7, t2: 2
//Received t1: 8, t2: 2
//Received t1: 9, t2: 2
//Received t1: 9, t2: 3
//Received t1: 10, t2: 3