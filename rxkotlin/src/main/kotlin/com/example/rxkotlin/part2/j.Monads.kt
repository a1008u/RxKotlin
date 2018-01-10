package com.example.rxkotlin.part2

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by AU on 1/9/2018.
 */

fun main(args: Array<String>) {
    val maybeValue: Maybe<Int> = Maybe.just(14)//1
    maybeValue.subscribeBy(//2
            onComplete = {println("Completed Empty")},
            onError = {println("Error $it")},
            onSuccess = { println("Completed with value $it")}
    )

    val maybeEmpty:Maybe<Int> = Maybe.empty()//3
    maybeEmpty.subscribeBy(
            onComplete = {println("Completed Empty")},//4　エラーなし　かつ　値なし
            onError = {println("Error $it")},//5　エラーあり
            onSuccess = { println("Completed with value $it")} //6 エラーなし　かつ　値あり
    )
}

//Completed with value 14
//Completed Empty