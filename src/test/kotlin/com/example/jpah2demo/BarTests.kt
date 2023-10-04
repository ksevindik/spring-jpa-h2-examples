package com.example.jpah2demo

import com.example.jpah2demo.model.Bar
import com.example.jpah2demo.model.Foo
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class BarTests : BaseIntegrationTests() {
    @Test
    fun testInsertWithPersist() {
        //given
        val bar1 = Bar("bar1")
        //when
        entityManager.persist(bar1)
        //then
        //flushAndClear()
        val bar2 = entityManager.find(Bar::class.java,bar1.id)
        MatcherAssert.assertThat(bar2,Matchers.equalTo(bar1))
    }

    @Test
    fun testInsertWithMerge() {
        val bar1 = Bar("bar1")
        //bar1.id = 1L
        val bar2 = entityManager.merge(bar1)
        flushAndClear()
        val bar3 = entityManager.find(Bar::class.java,bar2.id)
        MatcherAssert.assertThat(bar2,Matchers.not(Matchers.sameInstance(bar1)))
        MatcherAssert.assertThat(bar3,Matchers.equalTo(bar1))
    }

    @Test
    fun testLazy() {
        var foo = Foo("foo")
        var bar1 = Bar("bar1")
        var bar2 = Bar("bar2")
        entityManager.persist(bar1)
        entityManager.persist(bar2)
        entityManager.persist(foo)

        entityManager.flush()
        //entityManager.clear()

        //openH2Console()

        //bar1.name = "bar11"
        //bar2.name = "bar22"

        //bar1 = entityManager.merge(bar1)
        //bar2 = entityManager.merge(bar2)
        //foo = entityManager.merge(foo)

        foo.name = "foo2"
        foo.barSet.add(bar1)
        foo.barSet.add(bar2)


        flushAndClear()

        foo = entityManager.find(Foo::class.java,foo.id)

        flushAndClear()

        //openH2Console()

        //foo = entityManager.merge(foo)

        println(foo.barSet.size)





    }
}