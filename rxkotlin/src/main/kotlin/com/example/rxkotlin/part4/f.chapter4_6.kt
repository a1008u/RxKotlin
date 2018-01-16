package com.example.rxkotlin.part4

import org.reactivestreams.Subscription
import org.reactivestreams.Subscriber
import io.reactivex.schedulers.Schedulers
import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/*
*  生産者と消費者の関係
*  - FlowableとSubscriber(Reactive Streamsの仕様を実装した):データ量が多い場合にしよう(DB連携)
*  - ObservableとObserver(バックプレッシャーの機能がない):データ量が少ない場合にしよう(UIからの入力)
*/
fun main(args: Array<String>) {
    // publisher(Flowable) - consumer(Subscriber)
    Flowable.range(1, 10)//(1)
            .map { MyItem5(it) }//(2)
            .observeOn(Schedulers.io())
            .subscribe(object : Subscriber<MyItem5> {//(3)

                // 最初に受け取るデータ数を指定（リクエストするデータ数がLong.MAX_VALUEの場合、通知するデータ数は無制限と見なす）
                override fun onSubscribe(subscription: Subscription) = subscription.request(Long.MAX_VALUE)//(4)

                override fun onNext(s: MyItem5?) {
                    runBlocking { delay(50) }
                    println("Subscriber received " + s!!)
                }

                override fun onError(e: Throwable) = e.printStackTrace()
                override fun onComplete() = println("Done!")
            })

    // 実行
    runBlocking { delay(600) }
}

data class MyItem5 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}

//MyItem Created 1
//MyItem Created 2
//MyItem Created 3
//MyItem Created 4
//MyItem Created 5
//MyItem Created 6
//MyItem Created 7
//MyItem Created 8
//MyItem Created 9
//MyItem Created 10
//Subscriber received MyItem5(id=1)
//Subscriber received MyItem5(id=2)
//Subscriber received MyItem5(id=3)
//Subscriber received MyItem5(id=4)
//Subscriber received MyItem5(id=5)
//Subscriber received MyItem5(id=6)
//Subscriber received MyItem5(id=7)
//Subscriber received MyItem5(id=8)
//Subscriber received MyItem5(id=9)
//Subscriber received MyItem5(id=10)
//Done!