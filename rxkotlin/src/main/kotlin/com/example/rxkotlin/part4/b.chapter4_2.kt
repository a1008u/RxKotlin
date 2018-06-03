package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/**
 * 標準で用意されているSchedulers
    Scheduler	動作
    computation	CPUバウンド用スレッドを生成する。データの加工など向け。コア数と同じ数のキャッシュされたスレッドを使ってイベント処理をする。I/O処理ってはいけない。
    io	        I/Oバウンド用のスレッドを生成する。DBアクセスなど向け。1つだけキャッシュされているスレッドを使ってイベント処理を行う。
    trampoline	ThredLocalに処理をキューイングし現在実行中の処理が完了したら逐次実行する。
    immediate	現在のスレッドを使ってイベントを処理する。処理を遅延することはできるがキューイングすることはできない。
    newThread	作業単位ごとに新しいスレッドを作ってイベントを処理する。
 */
fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9)//(1)

    observable
        .map { MyItem(it) } //(2)
        .observeOn(Schedulers.computation()) //(3)
        .subscribe({
            println("Received $it") //(4)
            runBlocking { delay(200) } //(5)
        })

    runBlocking { delay(2000) }//(6)
}

data class MyItem (val id:Int) {

    init {
        println("MyItem Created $id")
    }
}

//MyItem Created 1
//Received MyItem(id=1)
//MyItem Created 2
//MyItem Created 3
//MyItem Created 4
//MyItem Created 5
//MyItem Created 6
//MyItem Created 7
//MyItem Created 8
//MyItem Created 9
//Received MyItem(id=2)
//Received MyItem(id=3)
//Received MyItem(id=4)
//Received MyItem(id=5)
//Received MyItem(id=6)
//Received MyItem(id=7)
//Received MyItem(id=8)
//Received MyItem(id=9)
