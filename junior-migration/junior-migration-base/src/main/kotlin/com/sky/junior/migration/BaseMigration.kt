package com.sky.junior.migration

interface BaseMigration {
    fun migration()
    fun order(): Int
}