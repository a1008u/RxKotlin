package com.example.rxkotlin.type9

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    Observable.range(1,10)
              .map {
                println("map - ${Thread.currentThread().name} $it")
                it
              }
              .compose(SchedulerManager(Schedulers.computation(), Schedulers.io()))
              .subscribe { println("onNext - ${Thread.currentThread().name} $it") }

    runBlocking { delay(100) }
}

class SchedulerManager<T>(private val subscribeScheduler:Scheduler
                          , private val observeScheduler:Scheduler):ObservableTransformer<T,T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T>
            = upstream.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
}

//map - RxComputationThreadPool-1 1
//onNext - RxCachedThreadScheduler-1 1
//map - RxComputationThreadPool-1 2
//map - RxComputationThreadPool-1 3
//map - RxComputationThreadPool-1 4
//map - RxComputationThreadPool-1 5
//map - RxComputationThreadPool-1 6
//map - RxComputationThreadPool-1 7
//map - RxComputationThreadPool-1 8
//map - RxComputationThreadPool-1 9
//onNext - RxCachedThreadScheduler-1 2
//map - RxComputationThreadPool-1 10
//onNext - RxCachedThreadScheduler-1 3
//onNext - RxCachedThreadScheduler-1 4
//onNext - RxCachedThreadScheduler-1 5
//onNext - RxCachedThreadScheduler-1 6
//onNext - RxCachedThreadScheduler-1 7
//onNext - RxCachedThreadScheduler-1 8
//onNext - RxCachedThreadScheduler-1 9
//onNext - RxCachedThreadScheduler-1 10