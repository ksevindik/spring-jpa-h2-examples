package com.example.jpah2demo

import org.h2.tools.Server
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ResourceLoader
import org.springframework.jdbc.datasource.DataSourceUtils
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.sql.DataSource

@SpringBootTest
@Transactional
abstract class BaseIntegrationTests {
    @Autowired
    protected lateinit var dataSource: DataSource

    @Autowired
    protected lateinit var entityManager: EntityManager

    fun openH2Console() {
        Server.startWebServer(DataSourceUtils.getConnection(dataSource))
    }

    fun flushAndClear() {
        entityManager.flush()
        entityManager.clear()
    }
}