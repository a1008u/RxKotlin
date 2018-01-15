package com.example.rxkotlin.part4

import io.reactivex.schedulers.Schedulers
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


fun main(args: Array<String>) {

    val source = Observable.range(1, 10)

    // BackpressureStrategy.DROP (データを通知できるようになるまで、新たに生成されたデータを破棄する)
    source.toFlowable(BackpressureStrategy.DROP)
            .map { MyItem8(it) }
            .observeOn(Schedulers.computation())
            .subscribe{
                println("Rec $it;\t")
                runBlocking { delay(100) }
            }

    runBlocking { delay(700) }
}

data class MyItem8 (val id:Int) {
    init {
        print("init $id;\t")
    }
}

//init 1;	init 2;	init 3;	init 4;	init 5;	init 6;	Rec MyItem8(id=1);
//init 7;	init 8;	init 9;	init 10;	Rec MyItem8(id=2);
//Rec MyItem8(id=3);
//Rec MyItem8(id=4);
//Rec MyItem8(id=5);
//Rec MyItem8(id=6);
//Rec MyItem8(id=7);