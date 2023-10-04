package com.example.jpah2demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ComponentConfig {
    @Bean
    fun testComponent() : TestComponent {
        return TestComponent()
    }
}