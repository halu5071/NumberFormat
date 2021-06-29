package io.moatwel.numberformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val formatter = NumberFormat.getInstance(Locale.JAPAN).apply {
        maximumFractionDigits = 0
        minimumFractionDigits = 0
        isGroupingUsed = true
    }
    private val value1 = BigDecimal("0.01234567")
    private val value2 = BigDecimal("0.41234567")
    private val value3 = BigDecimal("1.01234567")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result1 = formatter.format(value1)
        val result2 = formatter.format(value2)
        val result3 = formatter.format(value3)

        println("MainActivity: result1: $result1") // 0.
        println("MainActivity: result2: $result2") // 0
        println("MainActivity: result3: $result3") // 1
    }
}
