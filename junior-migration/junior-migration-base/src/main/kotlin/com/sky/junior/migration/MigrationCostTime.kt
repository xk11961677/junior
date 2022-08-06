package com.sky.junior.migration

import org.slf4j.LoggerFactory

abstract class MigrationCostTime : BaseMigration {
    private val log = LoggerFactory.getLogger(MigrationCostTime::class.java)
    override fun migration() {
        val start = System.currentTimeMillis()
        log.info("开始处理:{}", this.javaClass.simpleName)
        execute()
        log.info("migration处理完成,cost:{}s", (System.currentTimeMillis() - start) / 1000)
    }

    abstract fun execute()
}