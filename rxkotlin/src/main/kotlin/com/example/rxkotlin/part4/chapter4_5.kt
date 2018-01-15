package com.example.rxkotlin.part4

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/**
 * observeOn()
 * これを呼んだ以降の処理を指定したスレッドで処理します。
 * よく使うスレッド（スケジューラー）はSchedulersクラスで用意されています。
 *
 *
 * subscribeOn()
 * Observableでデータを作る処理をどのスレッドで実行するかを指定するメソッドです。
 * チェーンのどこで呼んでもかまいません。
 *
 */
fun main(args: Array<String>) {
   Flowable.range(1,1000)//(1)
            .map { MyItem4(it) }//(2)
            .observeOn(Schedulers.computation())
            .subscribe({//(3)
                print("Received $it;\t")
                runBlocking { delay(50) }//(4)
            },{it.printStackTrace()})
    runBlocking { delay(70000) }//(5)
}


data class MyItem4 (val id:Int) {
    init {
        print("MyItem Created $id;\t")
    }
}
