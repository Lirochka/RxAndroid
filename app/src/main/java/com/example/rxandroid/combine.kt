package com.example.rxandroid

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
fun main1(){
    //Излучает данные каждую секунду, но берем только 2
    val source1 = Observable.interval(1, TimeUnit.SECONDS)
        .take(2)
        .map { l -> l + 1 }
        .map { l -> "Источник 1: $l секунд"}

    //Излучает данные каждую 300 миллесекунд
    val  source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
        .map{ l -> (l + 1) * 300}
        .map { l -> "Источник 2: $l миллесекунд"}

    //Здесь применяем оператор merge()
    Observable.merge(source1, source2)
        .subscribe{ i -> println(i) }

    //Подождем 5 секунд - чтобы метод не завершился раньше времени
    Thread.sleep(5000)
}

fun main2(){
    //Излучает данные каждую секунду, но берем только 2
    val source1 = Observable.interval(1, TimeUnit.SECONDS)
        .take(2)
        .map { l -> l + 1 }
        .map { l -> "Источник 1: $l секунд"}

    //Излучает данные каждую 300 миллесекунд
    val  source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
        .map{ l -> (l + 1) * 300}
        .map { l -> "Источник 2: $l миллесекунд"}

    //Здесь применяем оператор merge()
    Observable.concat(source1, source2)
        .subscribe{ i -> println(i) }

    //Подождем 5 секунд - чтобы метод не завершился раньше времени
    Thread.sleep(5000)
}

fun main3(){
    val source1 = Observable.interval(50, TimeUnit.MILLISECONDS)
        .map { i: Long -> "Red $i" }
        .take(3)
        .doOnNext { x: String? -> println(x) }

    val source2 = Observable.interval(260, TimeUnit.MILLISECONDS)
        .map { i: Long -> "Green $i" }
        .take(3)
        .doOnNext { x: String? -> println(x) }

    val source3 = Observable.interval(151, TimeUnit.MILLISECONDS)
        .map { i: Long -> "Blue $i" }
        .take(2)
        .doOnNext { x: String? -> println(x) }

    Observable.merge(source1, source2, source3)
        .debounce(100, TimeUnit.MILLISECONDS)
        .subscribe{ x: String? -> println("Result $x") }

    Thread.sleep(5000)
}

fun main(){
    val source1 = Observable.fromArray(1, 2, 3)
    val source2 = Observable.fromArray("A", "B")

    Observable.zip(source1, source2,
        BiFunction<Int, String, String> { number, string ->
            string + number
        }).subscribe { s -> println(s) }
}