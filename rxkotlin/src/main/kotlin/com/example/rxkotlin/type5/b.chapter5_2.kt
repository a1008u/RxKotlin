package com.example.rxkotlin.type5

import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit


/**
 * throttleWithTimeout／debounceメソッド
 * 元のFlowable／Observableからデータを受け取った後、
 * 指定した期間内に別のデータを受け取らなければ、そのデータを通知することを繰り返すオペレータです。
 * 期間内に別のデータが来たら、次はそのデータから指定した期間に別のデータが来ないか計測します。
 *
 * ただし、指定した時間内であっても完了やエラーの通知は可能で、
 * 完了が通知される場合は最後に通知されるデータとともに完了を通知し、エラーの場合はエラーのみ通知します。
 */

fun main(args: Array<String>) {
    createObservable()//(1)
            .debounce(200, TimeUnit.MILLISECONDS)//(2)
            .subscribe { println(it) } //(3)
}

inline fun createObservable():Observable<String> = Observable.create<String> {
    it.onNext("R")//(4)
    runBlocking { delay(100) }//(5)
    it.onNext("Re")
    it.onNext("Reac")
    runBlocking { delay(230) }
    it.onNext("Reactiv")
    runBlocking { delay(140) }
    it.onNext("Reactive")
    runBlocking { delay(250) }//(6)
    it.onNext("Reactive P")
    runBlocking { delay(130) }
    it.onNext("Reactive Pro")
    runBlocking { delay(100) }
    it.onNext("Reactive Progra")
    runBlocking { delay(100) }
    it.onNext("Reactive Programming")
    runBlocking { delay(300) }
    it.onNext("Reactive Programming in")
    runBlocking { delay(100) }
    it.onNext("Reactive Programming in Ko")
    runBlocking { delay(150) }
    it.onNext("Reactive Programming in Kotlin")
    runBlocking { delay(250) }
    it.onComplete()
}

// 0.2秒以上を使って入力されたものを表示
//Reac
//Reactive
//Reactive Programming
//Reactive Programming in Kotlin