package com.example.rxkotlin.part3

import io.reactivex.subjects.ReplaySubject

/**
 * Created by AU on 1/11/2018.
 */

/**
 * 送出した値を全てキャッシュするSubjectです。
 * OnNext()が呼び出される度に値をため込み、Subscribeされた時、それまでため込んだ値を全て送出します。
 * こちらもキャッシュの送出後はノーマルのSubjectと同様な挙動になります。
 */
fun main(args: Array<String>) {
    val subject = ReplaySubject.create<Int>(2)
    subject.onNext(1)
    subject.onNext(2)

    subject.subscribe(
        { println("S1 Received $it") } // onNext
        ,{it.printStackTrace() }       // onError
        ,{println("S1 Complete") }     // onComplete
    )

    println("-----------------------------")

    subject.onNext(3)

    subject.subscribe(
            { println("S2 Received $it") } // onNext
            ,{ it.printStackTrace() }      // onError
            ,{ println("S2 Complete") }    // onComplete
    )

    subject.onNext(4)
    subject.subscribe(
            { println("S3 Received $it") } // onNext
            ,{ it.printStackTrace() }      // onError
            ,{ println("S3 Complete") }    // onComplete
    )

    subject.onNext(5)
    subject.onNext(6)

    subject.onComplete()
}

//S1 Received 1
//S1 Received 2
//S1 Received 3
//S1 Received 4
//-----------------------------
//S1 Received 5
//S2 Received 1
//S2 Received 2
//S2 Received 3
//S2 Received 4
//S2 Received 5
//S1 Complete
//S2 Complete
