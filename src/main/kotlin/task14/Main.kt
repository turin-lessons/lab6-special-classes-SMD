package org.example.task14

sealed interface Outcome<out T> {
    data class Ok<T>(val value: T) : Outcome<T>

    data class Fail(val reason: String) : Outcome<Nothing>
}

fun parseQuantity(text: String): Outcome<Int> {
    val number = text.trim().toIntOrNull()
        ?: return Outcome.Fail("'$text' is not a whole number")

    if (number <= 0) {
        return Outcome.Fail("The quantity must be positive")
    }

    if (number > 100) {
        return Outcome.Fail("We cannot sell more than 100 at once")
    }

    return Outcome.Ok(number)
}

fun parsePrice(text: String): Outcome<Double> {
    val price = text.trim().toDoubleOrNull()
        ?: return Outcome.Fail("'$text' is not a price")

    if (price <= 0.0) {
        return Outcome.Fail("The price must be positive")
    }

    return Outcome.Ok(price)
}

fun parseEmail(text: String): Outcome<String> {
    val email = text.trim()

    if ('@' !in email) {
        return Outcome.Fail("The e-mail must contain @")
    }

    return Outcome.Ok(email)
}

fun main() {
    print("Quantity: ")

    val quantity = when (val result = parseQuantity(readln())) {
        is Outcome.Fail -> {
            println("Quantity error: ${result.reason}")
            return
        }

        is Outcome.Ok -> result.value
    }

    print("Unit price: ")

    val price = when (val result = parsePrice(readln())) {
        is Outcome.Fail -> {
            println("Price error: ${result.reason}")
            return
        }

        is Outcome.Ok -> result.value
    }

    print("E-mail: ")

    val email = when (val result = parseEmail(readln())) {
        is Outcome.Fail -> {
            println("E-mail error: ${result.reason}")
            return
        }

        is Outcome.Ok -> result.value
    }

    println("E-mail: $email")
    println("Total: ${quantity * price}")
}