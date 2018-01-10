package com.example.rxkotlin.part2

/**
 * Created by AU on 1/9/2018.
 */

inline fun highOrderFuncInline(a:Int, validityCheckFunc:(a:Int)->Boolean) {//(1)
    if(validityCheckFunc(a)) //(2)
        println("a $a is Valid")
    else
        println("a $a is Invalid")
}

fun main(args: Array<String>) {
    highOrderFuncInline(12,{ a:Int -> a.isEven()}) //(3)
    highOrderFuncInline(19,{ a:Int -> a.isEven()})
}


//a 12 is Valid
//a 19 is Invalid