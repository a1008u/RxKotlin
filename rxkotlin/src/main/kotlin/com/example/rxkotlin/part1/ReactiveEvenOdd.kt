package com.example.rxkotlin.part1

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Created by AU on 1/9/2018.
 */

fun main(args: Array<String>) {

    var subject: Subject<Int> = PublishSubject.create()

    subject.map({ isEven2(it) })
           .subscribe({println("The number is ${(if (it) "Even" else "Odd")}" )})

    subject.onNext(4)
    subject.onNext(9)
}

inline fun isEven2(n:Int):Boolean = ((n % 2) == 0)