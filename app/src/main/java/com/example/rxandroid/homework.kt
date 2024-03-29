package com.example.rxandroid

import io.reactivex.Observable

data class Book(
    val title: String,
    val author: String,
    val id: Long?,
    val price: Double,
    val location: String,
    val currency: String,
)

fun main() {
    fun getBooksList(): List<Book> {
        return listOf(
            Book("Шантарам", "Грегори Дэвид Робертс", 1, 780.0, "Москва", "₽"),
            Book("Три товарища", "Эрих Мария Ремарк", 2, 480.0, "Москва", "₽"),
            Book("Цветы для Элджернона", "Даниел Киз", 3, 380.0, "Москва", "₽"),
            Book(" Атлант расправил плечи", "Айн Рэнд", 4, 880.0, "Ставрополь", "₽"),
            Book(" Атлант расправил плечи", "Айн Рэнд", 4, 580.0, "Сочи", "₽")
        )
    }
    Observable.fromIterable(getBooksList())
        .filter { it.location == "Москва" }
        .filter { it.price > 400.00 }
        .distinct { it.title }
        .map { it.title + " " + it.author }
        .subscribe{b -> println(b) }
}
