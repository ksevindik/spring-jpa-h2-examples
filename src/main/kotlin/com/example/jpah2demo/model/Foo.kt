package com.example.jpah2demo.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.NamedAttributeNode
import javax.persistence.NamedEntityGraph
import javax.persistence.OneToMany

@NamedEntityGraph(
    name = "foo.bars",
    attributeNodes = [NamedAttributeNode("barSet")]
)
@Entity
class Foo(@Column(unique = true) var name:String) {
    @Id
    @GeneratedValue
    val id:Long? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="foo_id")
    var barSet = mutableSetOf<Bar>()
}