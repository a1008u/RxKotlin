package com.example.rxkotlin.type5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {

    // accumulation 55
    Observable.range(1,10)
              .reduce { previousAccumulation, newEmission ->  previousAccumulation + newEmission  }
              .subscribeBy { println("accumulation $it") }

    // accumulation 12345
    Observable.range(1,5)
              .reduce { previousAccumulation, newEmission ->  previousAccumulation * 10 + newEmission  }
              .subscribeBy { println("accumulation $it") }
}


