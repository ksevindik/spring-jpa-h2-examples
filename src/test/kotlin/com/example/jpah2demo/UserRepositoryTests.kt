package com.example.jpah2demo

import com.example.jpah2demo.model.User
import com.example.jpah2demo.repository.UserRepository
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryTests : BaseIntegrationTests() {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `it should persist and find User by id`() {
        val user = User("user1","secret")
        userRepository.save(user)
        flushAndClear()
        val userFound = userRepository.findById(user.id!!).get()
        MatcherAssert.assertThat(userFound, Matchers.equalTo(user))
        openH2Console()
    }
}