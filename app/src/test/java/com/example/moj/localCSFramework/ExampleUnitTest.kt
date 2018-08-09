package com.example.moj.localCSFramework

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        assertEquals(4, MainActivity().add(2,2))
        assertEquals(100,MainActivity().add(50,51))
    }
}
