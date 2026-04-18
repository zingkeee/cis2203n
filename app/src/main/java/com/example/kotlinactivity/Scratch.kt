package com.example.kotlinactivity

fun greetUser(name: String): String {
    return "Hello, $name! Welcome to Kotlin."
}

fun main() {
    var nickname: String? = null

    println(nickname?.length)

    nickname = "Neil"

    println(nickname?.length)
}