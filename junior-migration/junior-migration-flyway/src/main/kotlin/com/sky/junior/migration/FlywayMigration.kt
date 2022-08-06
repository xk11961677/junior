package com.sky.junior.migration

import org.slf4j.LoggerFactory

class FlywayMigration : MigrationCostTime() {
    override fun order(): Int {
        return 3
    }

    override fun execute() {
        log.info("flyway migration run $SKIP_MIGRATION_FLYWAY_KEY")
    }

    companion object {
        private val log = LoggerFactory.getLogger(FlywayMigration::class.java)
        const val SKIP_MIGRATION_FLYWAY_KEY = "flyway.disabled"
    }
}