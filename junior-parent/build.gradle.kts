description = "junior-parent (Bill of Materials with Dependencies)"

plugins {
    `java-platform`
    id("com.conventions.publish")
}

// 允许定义platform依赖项
javaPlatform {
    allowDependencies()
}

// 定义依赖版本
dependencies{
    constraints {
        api("org.slf4j:slf4j-api:1.7.36")
        api("org.flywaydb:flyway-core") {
            // 添加强制使用此版本,因为spring-boot-dependencies存在8.3版本
            version {
                strictly("5.2.1")
            }
        }
    }
    api(platform("org.springframework.boot:spring-boot-dependencies:${Versions.SPRING_BOOT_VERSION}"))
    api(platform("org.jetbrains.kotlin:kotlin-bom:${Versions.KOTLIN_VERSION}"))
    // todo slw 这个协程怎么没有1.7的呢 ?
    //api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4"))
}