package com.example.rxkotlin.type7

/**
 * Created by AU on 1/10/2018.
 */

inline fun Int.isEven():Boolean = (this%2)==0
infix inline fun Sequence<Any>.join(delimeter:String):String {
    var retString = ""
    this.forEach {
        retString+= "$it${delimeter.trim()} "
    }
    return retString.substring(0,retString.lastIndexOf(delimeter)).trim()
}

inline fun Any.toIntOrError():Int = toString().toInt()
