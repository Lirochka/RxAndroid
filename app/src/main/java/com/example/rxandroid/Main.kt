package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

// create Observable with just example
//fun main(){
//
//    val months = Observable.just(
//        "January", "February", "March",
//        "April", "May", "June",
//        "July", "August"
//    )
//
//    months.subscribe(object : Observer<String> {
//        override fun onSubscribe(d: Disposable) {
//            println("onSubscribe: " + Thread.currentThread().name + "\n")
//        }
//
//        override fun onNext(t: String) {
//            println("onNext: $t")
//        }
//
//        override fun onError(e: Throwable) {
//            println("onError: $e")
//        }
//
//        override fun onComplete() {
//            println("\nonComplete")
//        }
//    })
//}

fun main(){

    val months = Observable.just(
       1, 2, 3, 4, 5, 6
    )

    months.subscribe(object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe: " + Thread.currentThread().name + "\n")
        }

        override fun onNext(t: Int) {
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