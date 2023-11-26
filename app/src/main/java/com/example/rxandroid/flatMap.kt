package com.example.rxandroid

import io.reactivex.Observable

fun main() {
    val initialSource: Observable<String> = Observable.just("day")

    initialSource.flatMap {
        if (it == "day") {
            return@flatMap Observable.just("Monday")
        } else {
            return@flatMap Observable.just("March")
        }
    }.subscribe { s -> println(s) }
}