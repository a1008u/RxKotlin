package com.example.rxkotlin.type8.chapter08

//(1)

import com.example.rxkotlin.type8.add
import com.example.rxkotlin.type8.divide
import com.example.rxkotlin.type8.mult
import com.example.rxkotlin.type8.substract
import org.junit.Test
import kotlin.test.*

class TestCalculator {
    @Test //(2)
    fun `addition test`() = assertEquals(1 + 2, add(1,2))

    @Test //(3)
    fun `substraction test`() = assertEquals(8-5, substract(8,5))

    @Test //(4)
    fun `multiplication test`() = assertEquals(4 * 2, mult(4,2))

    @Test //(5)
    fun `division test`() = assertEquals(8 / 2, divide(8,2))
}