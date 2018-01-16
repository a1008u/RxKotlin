package com.example.rxkotlin.part4

import io.reactivex.Flowable
import org.reactivestreams.Subscriber

fun main(args: Array<String>) {
    val flowable = Flowable.range(1,111)

    flowable.buffer(10,15)//(1)
            .subscribe { println("Subscription 1 $it") }

    flowable.buffer(15,7)//(2)
            .subscribe { println("Subscription 2 $it") }
}

//Subscription 1 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//Subscription 1 [16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
//Subscription 1 [31, 32, 33, 34, 35, 36, 37, 38, 39, 40]
//Subscription 1 [46, 47, 48, 49, 50, 51, 52, 53, 54, 55]
//Subscription 1 [61, 62, 63, 64, 65, 66, 67, 68, 69, 70]
//Subscription 1 [76, 77, 78, 79, 80, 81, 82, 83, 84, 85]
//Subscription 1 [91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
//Subscription 1 [106, 107, 108, 109, 110, 111]
//Subscription 2 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
//Subscription 2 [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
//Subscription 2 [15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
//Subscription 2 [22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36]
//Subscription 2 [29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43]
//Subscription 2 [36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50]
//Subscription 2 [43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57]
//Subscription 2 [50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64]
//Subscription 2 [57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71]
//Subscription 2 [64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78]
//Subscription 2 [71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85]
//Subscription 2 [78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92]
//Subscription 2 [85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]
//Subscription 2 [92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106]
//Subscription 2 [99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111]
//Subscription 2 [106, 107, 108, 109, 110, 111]