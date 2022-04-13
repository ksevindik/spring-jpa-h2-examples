package com.example.jpah2demo

import com.example.jpah2demo.model.Foo
import com.example.jpah2demo.repository.FooRepository
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.test.context.ContextConfiguration
import javax.sql.DataSource

@ContextConfiguration
class FooRepository1Tests @Autowired constructor(private val fooRepository: FooRepository,
                                                 private val configurableEnvironment: ConfigurableEnvironment) : BaseIntegrationTests() {

    @TestConfiguration
    class TestConfig

    @Test
    fun `it should persist foo`() {
        fooRepository.save(Foo("my-foo"))
        flushAndClear()
        val resultList = fooRepository.findByName("my-foo")
        MatcherAssert.assertThat(resultList.size, Matchers.equalTo(1))
        println(""">>1>${configurableEnvironment.getProperty("spring.datasource.url")}""")
    }
}