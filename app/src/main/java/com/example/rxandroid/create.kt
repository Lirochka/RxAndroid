package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe

// create Observable with create example
fun main() {
    val source = Observable.create(ObservableOnSubscribe<String> { emitter ->
        emitter.onNext("Java")
        emitter.onNext("Kotlin")
        emitter.onNext("Go")
        emitter.onNext("Cpp")
        emitter.onNext("Python")
        emitter.onComplete()
    })
   source.subscribe{value ->
       println(value)
   }
}