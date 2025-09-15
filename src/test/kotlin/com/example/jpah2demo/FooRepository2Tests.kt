package com.example.jpah2demo

import com.example.jpah2demo.model.Bar
import com.example.jpah2demo.model.Baz
import com.example.jpah2demo.model.Foo
import com.example.jpah2demo.repository.FooRepository
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.jdbc.datasource.DataSourceUtils
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
class FooRepository2Tests @Autowired constructor(private val fooRepository: FooRepository,
                                                 private val configurableEnvironment: ConfigurableEnvironment) : BaseIntegrationTests() {

    @TestConfiguration
    class TestConfig

    @Test
    fun `it should persist foo`() {
        fooRepository.save(Foo("my-foo"))
        flushAndClear()
        val resultList = fooRepository.findByName("my-foo")
        MatcherAssert.assertThat(resultList.size,Matchers.equalTo(1))
        println(""">>2>${configurableEnvironment.getProperty("spring.datasource.url")}""")
    }

    @Test
    fun `it should return dto foo views`() {
        fooRepository.saveAll(listOf(Foo("my-foo"),Foo("your-foo"),Foo("their-foo"), Foo("my-moo")))
        flushAndClear()
        val resultList = fooRepository.findByNameContains("foo")
        MatcherAssert.assertThat(resultList.map { it.getName() }, Matchers.containsInAnyOrder("my-foo","your-foo","their-foo"))
        val resultList2 = fooRepository.findByNameContains("my")
        MatcherAssert.assertThat(resultList2.map { it.getName() }, Matchers.containsInAnyOrder("my-foo","my-moo"))
    }

    @Test
    fun `it should return dto foo list`() {
        fooRepository.saveAll(listOf(Foo("my-foo"),Foo("your-foo"),Foo("their-foo"), Foo("my-moo")))
        flushAndClear()
        val resultList = fooRepository.findFooListByName("foo")
        MatcherAssert.assertThat(resultList.map { it.name }, Matchers.containsInAnyOrder("my-foo","your-foo","their-foo"))
        val resultList2 = fooRepository.findFooListByName("my")
        MatcherAssert.assertThat(resultList2.map { it.name }, Matchers.containsInAnyOrder("my-foo","my-moo"))
    }

    @Test
    fun `it should return all foo entities with barSet and bazSet eagerly initialized`() {
        val foo1 = Foo("foo-1")
        val bar1 = Bar("bar-1")
        val baz1 = Baz("baz-1")

        foo1.barSet.add(bar1)
        bar1.bazSet.add(baz1)

        fooRepository.save(foo1)

        flushAndClear()

        val result = fooRepository.findFooEntitiesWithBarsAndBaz()
        MatcherAssert.assertThat(result.map { it.name }.first(), Matchers.equalTo("foo-1"))
    }
}