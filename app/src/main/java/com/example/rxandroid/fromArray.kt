package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

// create Observable with fromArray example
fun eeeee(){

    val list = listOf(
        "January", "February", "March",
        "April", "May", "June",
        "July", "August"
    )

    val monthsIterable = Observable.fromArray(list)

    monthsIterable.subscribe(object : Observer<List<String>> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe: " + Thread.currentThread().name + "\n")
        }

        override fun onNext(t: List<String>) {
            println("onNext: $t")
        }

        override fun onError(e: Throwable) {
            println("onError: $e")
        }

        override fun onComplete() {
            println("\nonComplete")
        }
    })
}

fun main(){

    val list = listOf(1, 2, 3, 4, 5, 6)

    val monthsIterable = Observable.fromArray(list)

    monthsIterable.subscribe(object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe: " + Thread.currentThread().name + "\n")
        }

        override fun onNext(t: List<Int>) {
            println("onNext: $t")
        }

        override fun onError(e: Throwable) {
            println("onError: $e")
        }

        override fun onComplete() {
            println("\nonComplete")
        }
    })
}