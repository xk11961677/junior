// 只能出现在settings.gradle , gradle自身使用
pluginManagement {
    repositories {
        mavenLocal()
        maven {
            name = "gradle"
            url = uri("https://plugins.gradle.org/m2/")
        }
        maven {
            name = "maven"
            url = uri("https://repo.maven.apache.org/maven2/")
        }
        maven {
            name = "aliyun"
            url = uri("https://maven.aliyun.com/nexus/content/groups/public")
        }
    }
}
rootProject.name = "junior"
include(":junior-bom")
//include(":junior-all")
include(":junior-parent")
include(":junior-migration-flyway")
include(":junior-migration-base")
include(":junior-migration")
project(":junior-migration-flyway").projectDir = file("junior-migration/junior-migration-flyway")
project(":junior-migration-base").projectDir = file("junior-migration/junior-migration-base")
