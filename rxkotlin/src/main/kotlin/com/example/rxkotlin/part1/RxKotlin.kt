package com.example.rxkotlin.part1

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


fun main(args: Array<String>) {

    println("【Not use RxKotlin】----------------------------------- ")
    var list1:List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f) // 1
    var iterator1 = list1.iterator() // 2

    while (iterator1.hasNext()) print("${iterator1.next()} ") // Prints each element 3
    println("")
    list1.map { i -> print("$i ") } // 4

    println("")
    println("【Use RxKotlin】-------------------------------------- ")
    var list:List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
    var observable: Observable<Any> = list.toObservable(); //1

    observable.subscribeBy(  // 2 named arguments for lambda Subscribers
            onNext = { print("$it ") },
            onError =  { it.printStackTrace() },
            onComplete = { println("Done!") }
    )

}


//【Not use RxKotlin】-----------------------------------
//One 2 Three Four 4.5 Five 6.0
//One 2 Three Four 4.5 Five 6.0
//【Use RxKotlin】--------------------------------------
//One 2 Three Four 4.5 Five 6.0 Done!

