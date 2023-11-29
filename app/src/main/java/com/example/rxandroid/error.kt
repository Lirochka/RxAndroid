package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.observers.TestObserver

fun test1() {
    val testObserver = TestObserver<Int>()
    val source = Observable.just(5, 0, 1)
        .map { i -> 10 / i }
        .onErrorReturnItem(200)

    source.subscribe(testObserver)
    testObserver.assertNoErrors()
    testObserver.assertComplete()
    testObserver.assertValueCount(2)
    testObserver.assertValues(2, 200)
}

fun test2() {
    val testObserver = TestObserver<Int>()
    val source = Observable.just(5, 2, 1, 0, 1)
        .map { i -> 10 / i }
        .onErrorResumeNext(Observable.just(100, 200, 300))

    source.subscribe(testObserver)

    testObserver.assertNoErrors()
    testObserver.assertComplete()
    testObserver.assertValueCount(6)
    testObserver.assertValues(2, 5, 10, 100, 200, 300)
}

fun main() {

    val source = Observable.just(5, 2, 1, 0, 1)
        .map { i -> 10 / i }
        .retry(1)

    source.subscribe({ i -> println("RECEIVED: " + i!!) },
        { e -> println("RECEIVED ERROR: $e") }
    )
}