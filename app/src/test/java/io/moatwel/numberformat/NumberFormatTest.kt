package io.moatwel.numberformat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class NumberFormatTest {

    private val formatter = NumberFormat.getInstance(Locale.JAPAN).apply {
        maximumFractionDigits = 0
        minimumFractionDigits = 0
        isGroupingUsed = true
    }
    private val value1 = BigDecimal("0.01234567")
    private val value2 = BigDecimal("0.41234567")
    private val value3 = BigDecimal("1.01234567")

    @Test
    fun test1() {
        val result = formatter.format(value1)

        assertEquals("0", result)
        assertNotEquals("0.", result)
    }

    @Test
    fun test2() {
        val result = formatter.format(value2)

        assertEquals("0", result)
    }

    @Test
    fun test3() {
        val result = formatter.format(value3)

        assertEquals("1", result)
    }
}
