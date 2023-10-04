package com.example.jpah2demo.repository

import com.example.jpah2demo.model.Foo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface FooRepository : JpaRepository<Foo,Long>, JpaSpecificationExecutor<Foo> {
    @Transactional(readOnly = true)
    fun findByName(name:String):List<Foo>

    @EntityGraph("foo.bars")
    override fun findAll(pageable: Pageable): Page<Foo>
}