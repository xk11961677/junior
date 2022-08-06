plugins {
    `maven-publish`
}
val internalBomModulesName by extra(Versions.internalBomModulesName)

// 定义发布配置
publishing {
    // 定义发布项目
    publications {
        register<MavenPublication>("mavenPublication") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            plugins.withId("java-platform") {
                from(components["javaPlatform"])
            }
            plugins.withId("java-library") {
                from(components["java"])
                versionMapping {
                    usage("java-api") {
                        fromResolutionOf("runtimeClasspath")
                    }
                    usage("java-runtime") {
                        fromResolutionResult()
                    }
                }
            }

            pom {
                name.set("junior")
                description.set("Lightweight base tool library")
                url.set("https://github.com/xk11961677/junior/blob/master/README.md")
                properties.set(mapOf("kotlin.version" to Versions.KOTLIN_VERSION))
                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://www.mit-license.org")
                    }
                }
                developers {
                    developer {
                        id.set("sky")
                        name.set("sky")
                        email.set("shen11961677@163.com")
                    }
                }
                scm {
                    connection.set("scm:git://github.com/xk11961677/junior.git")
                    developerConnection.set("scm:git:ssh://git@github.com:xk11961677/junior.git")
                    url.set("https://github.com/xk11961677/junior.git")
                }
                organization {
                    name.set("sky")
                    url.set("https://sky-blogs.netlify")
                }
                issueManagement {
                    system.set("github")
                    url.set("https://github.com/xk11961677/junior/issues")
                }
            }
        }
    }
    // 仓库定义(可以发布到Nexus私服等)
    repositories {
        maven {
            credentials {
                username = "${System.getenv("NEXUS_USER")?:System.getProperty("NEXUS_USER")}"
                password = "${System.getenv("NEXUS_PASSWORD")?:System.getProperty("NEXUS_PASSWORD")}"
            }
            isAllowInsecureProtocol = true

            val projectVersionStr = project.version.toString()

            if (projectVersionStr.endsWith("RELEASE")) {
                url = uri("https://repo.rdc.aliyun.com/repository/109496-release-o4UFqu")
            }
            if (projectVersionStr.endsWith("SNAPSHOT")) {
                url = uri("https://repo.rdc.aliyun.com/repository/109496-snapshot-yQkopR")
            }
            if(!projectVersionStr.endsWith("RELEASE") && !projectVersionStr.endsWith("SNAPSHOT")) {
                throw IllegalArgumentException("版本后缀不符合规范")
            }
        }
    }
}