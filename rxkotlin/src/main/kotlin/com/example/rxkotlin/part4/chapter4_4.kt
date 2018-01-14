package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
   //(1)
   Observable.range(1,1000)
             .map { MyItem3(it) }//(2)
             .observeOn(Schedulers.computation())
             .subscribe({
                 print("Received $it;\t") //(3)
                 runBlocking { delay(50) } //(4)
             },{it.printStackTrace()})

    runBlocking { delay(80000) } //(5)
}


data class MyItem3 (val id:Int) {
    init {
        print("MyItem Created $id;\t")
    }
}
