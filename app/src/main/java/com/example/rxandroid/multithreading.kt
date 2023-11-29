package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


fun main(){
    val source = Observable.just(1, 2)

    source
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.newThread())
        .subscribe{ i -> println("Received " + i + " on thread " + Thread.currentThread().name) }

    Thread.sleep(5000)

    println("--------------------------------------")

    val source2 = Observable.just(1, 2)
    source2.subscribeOn(Schedulers.computation())
        .subscribeOn(Schedulers.newThread())
        .subscribe { i ->
            println("Received " + i + " on thread " + Thread.currentThread().name)
        }

    Thread.sleep(5000)

    println("--------------------------------------")

    val source3 = Observable.just(1, 2)
    source3.subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.newThread())
        .observeOn(Schedulers.computation())
        .subscribe { i ->
            println("Received " + i + " on thread " + Thread.currentThread().name)
        }

    Thread.sleep(5000)
}