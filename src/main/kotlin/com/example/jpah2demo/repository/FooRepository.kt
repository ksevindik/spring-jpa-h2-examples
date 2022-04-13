package com.example.jpah2demo.repository

import com.example.jpah2demo.model.Foo
import org.springframework.data.repository.CrudRepository

interface FooRepository : CrudRepository<Foo,Long> {
    fun findByName(name:String):List<Foo>
}