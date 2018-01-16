package com.example.rxkotlin.type9

import io.reactivex.Observable
import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    Observable.range(10,20)
            .lift(AddSerialNumber<Int>())
            .subscribeBy (
                    onNext = { println("Next $it") },
                    onError = { it.printStackTrace() },
                    onComplete = { println("Completed") }
            )
}

class AddSerialNumber<T> : ObservableOperator<Pair<Int,T>,T> {
    val counter:AtomicInteger = AtomicInteger()

    override fun apply(observer: Observer<in Pair<Int, T>>): Observer<in T> {
        return object : Observer<T> {
            override fun onComplete() = observer.onComplete()
            override fun onSubscribe(d: Disposable) = observer.onSubscribe(d)
            override fun onError(e: Throwable) = observer.onError(e)
            override fun onNext(t: T) = observer.onNext(Pair(counter.incrementAndGet(),t))
        }
    }
}

//Next (1, 10)
//Next (2, 11)
//Next (3, 12)
//Next (4, 13)
//Next (5, 14)
//Next (6, 15)
//Next (7, 16)
//Next (8, 17)
//Next (9, 18)
//Next (10, 19)
//Next (11, 20)
//Next (12, 21)
//Next (13, 22)
//Next (14, 23)
//Next (15, 24)
//Next (16, 25)
//Next (17, 26)
//Next (18, 27)
//Next (19, 28)
//Next (20, 29)
//Completed