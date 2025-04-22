package com.example.mui5.data

fun parceUrl(input: String): String {
    val trimmedInput = input.trim()
    return when {
        trimmedInput.startsWith("http://") || trimmedInput.startsWith("https://") -> trimmedInput
        "." in trimmedInput -> "https://$trimmedInput"
        else -> "https://www.google.com/search?q=$trimmedInput"
    }
}