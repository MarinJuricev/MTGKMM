package com.example.mtgkmm.core.ext

import kotlin.test.Test
import kotlin.test.assertEquals

class MapperExtKtTest {

    @Test
    fun `orZero on nullable Int SHOULD return Int WHEN Int is not null`() {
        val entry = 4

        val result = entry.orZero()

        assertEquals(expected = entry, actual = result)
    }

    @Test
    fun `orZero on nullable Int SHOULD return zero WHEN Int is null`() {
        val entry: Int? = null

        val result = entry.orZero()

        assertEquals(expected = 0, actual = result)
    }

    @Test
    fun `orFalse on nullable Boolean SHOULD return Boolean WHEN Boolean is not null`() {
        val entry = true

        val result = entry.orFalse()

        assertEquals(expected = entry, actual = result)
    }

    @Test
    fun `orFalse on nullable Boolean SHOULD return false WHEN Boolean is null`() {
        val entry: Boolean? = null

        val result = entry.orFalse()

        assertEquals(expected = false, actual = result)
    }

    @Test
    fun `orZero on nullable String SHOULD return Int WHEN String is not null and is a number`() {
        val entry = "123"

        val result = entry.orZero()

        assertEquals(expected = 123, actual = result)
    }

    @Test
    fun `orZero on nullable String SHOULD return 0 WHEN String is null`() {
        val entry: String? = null

        val result = entry.orZero()

        assertEquals(expected = 0, actual = result)
    }

    @Test
    fun `orZero on nullable String SHOULD return 0 WHEN String is not null and not a number`() {
        val entry = "entry"

        val result = entry.orZero()

        assertEquals(expected = 0, actual = result)
    }
}
