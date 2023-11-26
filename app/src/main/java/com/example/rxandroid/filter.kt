package com.example.rxandroid

import io.reactivex.Observable


fun main(){
    val sourceDis = Observable.fromArray(1,2,1,4,8,7,1,11,5,0,0,6,23)
    sourceDis.distinct().subscribe{s -> println("Distinct: $s") }

    println("----------------------------------------")

    val sourceElement = Observable.fromArray(1,5,4,8)
    sourceElement.elementAt(2).subscribe{s -> println("ElementAt: $s") }
}