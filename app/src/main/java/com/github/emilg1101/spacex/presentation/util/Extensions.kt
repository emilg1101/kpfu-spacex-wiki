package com.github.emilg1101.spacex.presentation.util

import java.text.SimpleDateFormat
import java.util.*

inline fun String.ifNotBlankOrEmpty(action: (String) -> Unit) {
    if (isNotEmpty() && isNotBlank()) action(this)
}

fun Date.format(pattern: String = "dd MMM`yy-hh:mm"): String {
    return SimpleDateFormat(pattern, Locale.US).format(this)
}