package io.moatwel.numberformat

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class NumberFormatTestOnAndroidTest {

    private val formatter = NumberFormat.getInstance(Locale.JAPAN).apply {
        maximumFractionDigits = 0
        minimumFractionDigits = 0
        isGroupingUsed = true
    }
    private val value1 = BigDecimal("0.01234567")
    private val value2 = BigDecimal("0.41234567")
    private val value3 = BigDecimal("1.01234567")
    private val value4 = BigDecimal("1000.001234567")

    @Test
    fun failed_to_obtain_string_0_from_value_1() {
        val result = formatter.format(value1)

        assertEquals("0", result)       // Failed below API 30
        assertNotEquals("0.", result) // Failed below API 30
    }

    @Test
    fun obtain_string_0_from_value_2_as_intended() {
        val result = formatter.format(value2)

        assertEquals("0", result)
    }

    @Test
    fun obtain_string_1_from_value_3_as_intended() {
        val result = formatter.format(value3)

        assertEquals("1", result)
    }

    @Test
    fun obtain_string_1000_from_value_4_as_intended() {
        val result = formatter.format(value4)

        assertEquals("1,000", result)
    }
}
