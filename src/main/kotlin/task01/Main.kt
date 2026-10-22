package org.example.task01

enum class OrderStatus {
    NEW, PAID, SHIPPED, DELIVERED, CANCELLED
}

fun parseWithTry(text: String): OrderStatus? = try {
    OrderStatus.valueOf(text.trim().uppercase())
} catch (e: IllegalArgumentException) {
    null
}

fun parseWithoutTry(text: String): OrderStatus? =
    OrderStatus.entries.firstOrNull {
        it.name.equals(text.trim(), ignoreCase = true)
    }

fun main() {
    println("Statuses: ${OrderStatus.entries.joinToString()}")
    print("Current status of your order: ")

    val text = readln().trim().uppercase()
    val status = parseWithoutTry(text)

    // Ikkinchi usul:
    // val status = parseWithTry(text)

    if (status == null) {
        println(
            "'$text' is not a status. Valid: " +
                    OrderStatus.entries.map { it.name }
        )
        return
    }

    println(
        "You entered ${status.name}: " +
                "step ${status.ordinal + 1} of ${OrderStatus.entries.size}"
    )

    val next = OrderStatus.entries.getOrNull(status.ordinal + 1)

    println(
        if (next == null) "This is the last step."
        else "Next step: $next"
    )

    println(OrderStatus.PAID === OrderStatus.valueOf("PAID"))
}