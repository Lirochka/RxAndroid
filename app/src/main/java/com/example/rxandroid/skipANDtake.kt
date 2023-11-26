package com.example.rxandroid

import io.reactivex.Observable

fun main() {
    val sourceTake = Observable.fromArray(1, 2, 3, 4)
    sourceTake.take(2).subscribe { s -> println("Take: $s") }

    println("----------------------------------------")

    val sourceSkip = Observable.fromArray(1, 2, 3, 4)
    sourceSkip.skip(2).subscribe { s -> println("Skip: $s") }

    println("----------------------------------------")

    val sourceTakeWhile = Observable.fromArray(1, 2, 3, 4, 0, 0, 3, 8, 12)
    sourceTakeWhile.takeWhile{x -> x < 6 }.subscribe { s -> println("TakeWhile: $s") }

    println("----------------------------------------")

    val sourceSkipWhile = Observable.fromArray(1, 2, 3, 4, 6, 8, 3, 8, 11)
    sourceSkipWhile.skipWhile{x -> x < 6 }.subscribe { s -> println("SkipWhile: $s") }
}