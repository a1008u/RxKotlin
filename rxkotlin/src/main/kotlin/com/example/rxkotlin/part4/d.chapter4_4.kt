package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/*
RxJavaでは、データを通知する側と受け取る側とで処理を別々のスレッドで実行させる場合、
observerOnメソッドの引数にSchedulerというスレッド管理を行うオブジェクトを設定することで、
どのようなスレッド上で処理を行うのかを指定します。

RxJava2.xのObserverを引数に受け取るsubscribeメソッドは戻り値を返さないようになっています。
そのため、このsubscribeメソッドを呼んだ場合はObserverの内部で購読の解除を行うような設計になっています。
*/

fun main(args: Array<String>) {
   //(1) //(2) //(3) //(4)
   Observable.range(1,1000)
             .map { MyItem3(it) }
             .observeOn(Schedulers.computation())
             .subscribe({ println("Received $it;\t")
                          runBlocking { delay(500) } }
                         ,{ it.printStackTrace()} )

    runBlocking { delay(8000) } //(5)
}


data class MyItem3 (val id:Int) {
    init {
        print("MyItem Created $id;\t")
    }
}

//MyItem Created 1;	Received MyItem3(id=1);
//MyItem Created 2;	MyItem Created 3;	MyItem Created 4;	MyItem Created 5;	MyItem Created 6;	MyItem Created 7;	MyItem Created 8;	MyItem Created 9;	MyItem Created 10;	Received MyItem3(id=2);
//Received MyItem3(id=3);
//Received MyItem3(id=4);
//Received MyItem3(id=5);
//Received MyItem3(id=6);
//Received MyItem3(id=7);
//Received MyItem3(id=8);
//Received MyItem3(id=9);
//Received MyItem3(id=10);