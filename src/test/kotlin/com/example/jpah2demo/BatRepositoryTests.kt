package com.example.jpah2demo

import com.example.jpah2demo.model.Bat
import com.example.jpah2demo.repository.BatRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.UUID

class BatRepositoryTests : BaseIntegrationTests() {
    @Autowired
    private lateinit var batRepository: BatRepository

    @Test
    fun `it should persist bat entity`() {
        batRepository.save(Bat().apply { this.id= UUID.randomUUID().toString() })
        flushAndClear()

        entityManager.persist(Bat().apply { this.id= UUID.randomUUID().toString() })
        flushAndClear()
    }
}