package com.example.jpah2demo.repository

import com.example.jpah2demo.model.Bar
import org.springframework.data.jpa.repository.JpaRepository

interface BarRepository : JpaRepository<Bar,Long> {
}