package com.example.rxandroid

import io.reactivex.Observable
import java.util.concurrent.Callable


// create Observable with fromCallable example
fun main() {
    val source= Observable.fromCallable(Callable {
        return@Callable System.currentTimeMillis().toString()
    })

    source.subscribe { s -> println("RECEIVED: $s") }
    Thread.sleep(5000)
    source.subscribe{s -> println("RECEIVED: $s")}

    println("--------------------------------------")

    val sourceJust = Observable.just(System.currentTimeMillis().toString())
    sourceJust.subscribe{s -> println("sourceJust: $s")}
    println("Sleeping 5s: ")
    Thread.sleep(5000)
    sourceJust.subscribe{s -> println("sourceJust: $s")}
}