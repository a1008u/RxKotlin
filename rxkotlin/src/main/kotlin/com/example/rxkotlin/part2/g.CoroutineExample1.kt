package com.example.rxkotlin.part2


import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Created by Created by AU on 1/9/2018.
 */

suspend fun longRunningTsk():Long {//(1)

    val time = measureTimeMillis {//(2)
        println("Please wait")
        delay(2,TimeUnit.SECONDS)//(3)
        println("Delay Over")
    }

    return time
}

fun main(args: Array<String>) {

    runBlocking {//(4)
        println("type1実施----------------")
        val exeTime = longRunningTsk()//(5)
        println("Execution Time is $exeTime")
    }

    val time = async(CommonPool) { longRunningTsk() }
    println("type2実施----------------")
    println("Print after async ")
    runBlocking { println("printing time ${time.await()}") }
}

//type1実施----------------
//Please wait
//Delay Over
//Execution Time is 2008
//type2実施----------------
//Print after async
//Please wait
//Delay Over
//printing time 2002