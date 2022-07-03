package com.example.mtgkmm.core.ext

inline fun Int?.orZero(): Int = this ?: 0

inline fun Boolean?.orFalse(): Boolean = this ?: false

inline fun String?.orZero(): Int = this?.toIntOrNull() ?: 0
