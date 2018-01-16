package com.example.rxkotlin.part4

import org.reactivestreams.Subscription
import org.reactivestreams.Subscriber
import io.reactivex.schedulers.Schedulers
import io.reactivex.Flowable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/*
Subscriberの設定可能メソッド
- onSubscribe
- onNext
- onError
- onComplete
*/
fun main(args: Array<String>) {
    Flowable.range(1, 15)
            .map { MyItem6(it) }
            .observeOn(Schedulers.io())
            .subscribe(object : Subscriber<MyItem6> {
                lateinit var subscription: Subscription//(1)

                // 最初に受け取るデータ数を指定
                override fun onSubscribe(subscription: Subscription) {
                    this.subscription = subscription
                    subscription.request(5)//(2)
                }

                // 処理が続く場合は、再度リクエストを設定する必要がある(subscriptionが必要)
                override fun onNext(s: MyItem6?) {
                    runBlocking { delay(50) }
                    println("Subscriber received " + s!!)
                    if(s.id == 5) {//(3)
                        println("Requesting two more")
                        subscription.request(2)//(4)
                    }
                }

                override fun onError(e: Throwable) = e.printStackTrace()
                override fun onComplete() = println("Done!")
            })

    // 実行
    runBlocking { delay(10000) }
}

data class MyItem6 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}

//
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
//MyItem Created 11
//MyItem Created 12
//MyItem Created 13
//MyItem Created 14
//MyItem Created 15
//Subscriber received MyItem6(id=1)
//Subscriber received MyItem6(id=2)
//Subscriber received MyItem6(id=3)
//Subscriber received MyItem6(id=4)
//Subscriber received MyItem6(id=5)
//Requesting two more
//Subscriber received MyItem6(id=6)
//Subscriber received MyItem6(id=7)