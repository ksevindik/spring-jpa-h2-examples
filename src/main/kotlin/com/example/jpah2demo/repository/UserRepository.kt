package com.example.jpah2demo.repository

import com.example.jpah2demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
}