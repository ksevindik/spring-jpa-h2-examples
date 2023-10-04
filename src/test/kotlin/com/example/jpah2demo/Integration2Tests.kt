package com.example.jpah2demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationContext

class Integration2Tests : BaseIntegrationTests() {

    @TestConfiguration
    class TestConfig

    @MockBean
    private lateinit var testComponent2: TestComponent

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Test
    fun test2() {
        println(testComponent2.toString())
        println(applicationContext.toString())
    }
}