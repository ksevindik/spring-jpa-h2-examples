package com.example.jpah2demo.model

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(var username:String,var password:String) {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    //@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator") "uuid" ve "uuid2" strateji isimleri de kullanılabilir
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    var id: UUID? = null
}