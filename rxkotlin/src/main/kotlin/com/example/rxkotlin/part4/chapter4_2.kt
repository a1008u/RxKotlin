package com.example.rxkotlin.part4

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9)//(1)

    observable
            //(2)
            .map { MyItem(it) }
            //(3)
            .observeOn(Schedulers.computation())
            //(4)
            .subscribe({
                println("Received $it")
                //(5)
                runBlocking { delay(200) }
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