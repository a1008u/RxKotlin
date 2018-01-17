package com.example.rxkotlin.type7

import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/**
 * subscribeOnメソッド
 * RxJavaでは生産者が処理を実行するスレッドの種類を設定
 * subscribeOnメソッドは生産者が行う処理のSchedulerを設定する性質上、1回しか設定できません。
 * 一度、subscribeOnメソッドを使ってSchedulerを設定すると、それより後に指定したsubscribeOnメソッドのSchedulerは無視されます。
 *
 * observeOnメソッド
 * データを受け取る側のスレッドの種類を設定
 * observeOnメソッドで指定したSchedulerが設定したスレッド上で、それ以降の処理を行うようになります。
 * また、observeOnメソッドがデータを受け取る側のSchedulerを指定するため、オペレータごとに異なるSchedulerを指定することが可能です。
 *
 * これらのスレッドの種類を設定するには、用途に応じたスレッドの管理を行うSchedulerを指定します。
 */

fun main(args: Array<String>) {
    listOf("1","2","3","4","5","6","7","8","9","10")
            .toObservable()
            .map {
                item-> println("Mapping $item - ${Thread.currentThread().name}")
                return@map item.toInt()
            }
            .subscribeOn(Schedulers.computation())//(1)
            .subscribe {
                item -> println("Received $item - ${Thread.currentThread().name}")
            }

    runBlocking { delay(1000) }
}

//Mapping 1 - RxComputationThreadPool-1
//Received 1 - RxComputationThreadPool-1
//Mapping 2 - RxComputationThreadPool-1
//Received 2 - RxComputationThreadPool-1
//Mapping 3 - RxComputationThreadPool-1
//Received 3 - RxComputationThreadPool-1
//Mapping 4 - RxComputationThreadPool-1
//Received 4 - RxComputationThreadPool-1
//Mapping 5 - RxComputationThreadPool-1
//Received 5 - RxComputationThreadPool-1
//Mapping 6 - RxComputationThreadPool-1
//Received 6 - RxComputationThreadPool-1
//Mapping 7 - RxComputationThreadPool-1
//Received 7 - RxComputationThreadPool-1
//Mapping 8 - RxComputationThreadPool-1
//Received 8 - RxComputationThreadPool-1
//Mapping 9 - RxComputationThreadPool-1
//Received 9 - RxComputationThreadPool-1
//Mapping 10 - RxComputationThreadPool-1
//Received 10 - RxComputationThreadPool-1