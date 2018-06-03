package com.example.rxkotlin.part3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit


/**
 * Created by AU on 1/10/2018.
 */

/**
 *
 * intervalメソッドは指定した通知間隔（インターバル）で0から始まるLong値のデータを通知するFlowable／Observableを生成するオペレータです。
 * 通知されるデータは「0」「1」「2」と順に通知されていきます。
 * このintervalメソッドで生成されたFlowable／ObservableはデフォルトでSchedulers.computation()のScheduler上で実行され、
 * 呼び出し元のスレッドとは異なるスレッド上で実行されます。
 *
 * timerメソッドは呼び出されてから指定した時間だけ待機した後、1つのLong値「0」を通知し完了するFlowable／Observableを生成するオペレータです。
 * このtimerメソッドで生成されたFlowable／ObservableはデフォルトでSchedulers.computation()のScheduler上で実行され、
 * 呼び出し元のスレッドとは異なるスレッド上で実行されます
 *
 */
fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() = println("All Completed")
        override fun onNext(item: Any) = println("Next $item")
        override fun onError(e: Throwable) = println("Error Occured ${e.message}")
        override fun onSubscribe(d: Disposable) = println("New Subscription ")
    }//Create Observer

    Observable
        .range(1,10)
        .subscribe(observer)//(1)

    println("---------")

    Observable
        .empty<String>()
        .subscribe(observer)//(2)

    println("--------------------")

    runBlocking {
        Observable
            .interval(300,TimeUnit.MILLISECONDS)
            .subscribe(observer)//(3)

        delay(900)

        val subscription = Observable
                .timer(400,TimeUnit.MILLISECONDS)
                .subscribe(observer)//(4)

        delay(450)
    }
}

//New Subscription
//Next 1
//Next 2
//Next 3
//Next 4
//Next 5
//Next 6
//Next 7
//Next 8
//Next 9
//Next 10
//All Completed
//---------
//New Subscription
//All Completed
//--------------------
//New Subscription <- interval
//Next 0 <- interval
//Next 1 <- interval
//Next 2 <- interval
//New Subscription <- timer
//Next 3 <- interval
//Next 0  <- timer
//All Completed  <- timer
