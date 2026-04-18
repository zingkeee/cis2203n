package com.example.kotlinactivity

fun greetUser(name: String): String {
    return "Hello, $name! Welcome to Kotlin."
}

fun main() {
    val greetingMessage = greetUser("Neil")
    println(greetingMessage)
}