package com.example.jpah2demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationContext

class Integration1Tests : BaseIntegrationTests() {
    @MockBean
    private lateinit var testComponent1: TestComponent

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Test
    fun test1() {
        println(testComponent1.toString())
        println(applicationContext.toString())
    }
}