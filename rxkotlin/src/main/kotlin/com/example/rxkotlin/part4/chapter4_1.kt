package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


/*
backpressure:::生産者が通知するデータの量を抑制することで、
消費者が受け取ったデータを処理しきれず大量のデータが処理待ちの状況になってしまうことを避けられるようにする。

Reactive      Streams	    RxJava 1.x	説明
Publisher     Observable	データを生産し通知するオブジェクト。
Subscriber    Observer	    受け取った通知をもとに処理を行うオブジェクト。RxJava 1.xではこのObserverを実装したSubscriberクラスが通知するデータ数をリクエストする機能も持つ。
Subscription  Subscription	購読を解除することができるオブジェクトであり、Reactive Streamsでは通知するデータ数をリクエストする機能も持つオブジェクト。

1.消費者が指定したデータ数だけデータを通知するようにリクエストする
2.生産者がリクエストを受けたデータ数だけデータを通知する。
3.生産者はリクエスト分のデータを通知したら通知を止めるが、データの生産は続ける。　＊設定で破棄するかバッファに残すか決める
4.消費者が受け取った最後のデータを処理したら、再度データ数をリクエストする。
5.リクエスト分のデータを再度通知し始める。
*/
fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9,10)//(1)
    val subject = BehaviorSubject.create<Int>()

    //(2) (3) (4)
    subject.observeOn(Schedulers.computation())
           .subscribe({
                println("Subs 1 Received $it")
                runBlocking { delay(300) }
            })

    //(5) (6)
    subject.observeOn(Schedulers.computation())
           .subscribe({ println("Subs 2 Received $it") })

    //(7) 実行
    observable.subscribe(subject)

    //(8)
    runBlocking { delay(2000) }
}


//Subs 1 Received 1
//Subs 2 Received 1
//Subs 2 Received 2
//Subs 2 Received 3
//Subs 2 Received 4
//Subs 2 Received 5
//Subs 2 Received 6
//Subs 2 Received 7
//Subs 2 Received 8
//Subs 2 Received 9
//Subs 2 Received 10
//Subs 1 Received 2
//Subs 1 Received 3
//Subs 1 Received 4
//Subs 1 Received 5
//Subs 1 Received 6
//Subs 1 Received 7