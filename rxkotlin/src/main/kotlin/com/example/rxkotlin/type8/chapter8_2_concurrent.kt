package com.example.rxkotlin.type8

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

// subscribeOn()::::Observableでデータを作る処理をどのスレッドで実行するかを指定するメソッド
fun main(args: Array<String>) {
    Observable.range(1,10)
              .subscribeOn(Schedulers.computation())
              .subscribe { item -> println("Received $item") }

    runBlocking { delay(10) }
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
//Received 10