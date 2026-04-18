package com.example.kotlinactivity

data class User(val username: String, var score: Int)

fun main() {
    val users = listOf(
        User("Neil", 100),
        User("Patrick", 85),
        User("Guest", 10)
    )

    for (user in users) {
        println("User: ${user.username} | Score: ${user.score}")
    }
}