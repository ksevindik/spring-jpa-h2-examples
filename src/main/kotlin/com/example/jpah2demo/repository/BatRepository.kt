package com.example.jpah2demo.repository

import com.example.jpah2demo.model.Bat
import org.springframework.data.jpa.repository.JpaRepository

interface BatRepository : JpaRepository<Bat,String> {
}