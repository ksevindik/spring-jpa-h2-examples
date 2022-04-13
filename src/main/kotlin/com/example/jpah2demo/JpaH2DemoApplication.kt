package com.example.jpah2demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaH2DemoApplication

fun main(args: Array<String>) {
	runApplication<JpaH2DemoApplication>(*args)
}
