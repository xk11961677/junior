import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * ==================================================
 * 在父工程中声明"构建插件的版本"，在子工程中可以不再声明版本
 * =================================================
 */
plugins {
    `java-library`
    idea /*Gradle自动生成Intellij的项目文件*/
    id("io.spring.dependency-management") version Versions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("kapt") version Versions.KOTLIN_VERSION apply false
    kotlin("plugin.spring") version Versions.KOTLIN_VERSION apply false
    kotlin("plugin.noarg")  version Versions.KOTLIN_VERSION apply false
    kotlin("plugin.allopen") version Versions.KOTLIN_VERSION  apply false
}

//父工程坐标（与子工程没有关系）
group = "com.sky.junior"

// 声明除junior-bom , junior-parent模块的其它所有模块
val internalBomModules by extra(Versions.internalBomModulesName.map{ project(":$it") })
val kotlinSubProjects by extra(subprojects - internalBomModules.toSet())
//val kotlinProjects by extra(kotlinSubProjects + rootProject)

/**
 * ==================================================
 * 配置所有项目
 * =================================================
 */
//configure(kotlinProjects)
allprojects {
    /**
     * ============================================================
     * 此坐标将成为子工程的默认项，
     * 配合settings.gradle中的rootProject.name='xxx',将完成项目定位
     * ============================================================
     */
    group = "com.sky.junior"
    configurations.all {
        resolutionStrategy {
            // 不使用缓存，使用仓库中最新的包 check for updates every build
            cacheChangingModulesFor(0, "seconds")
            cacheDynamicVersionsFor(0, "seconds")
        }
    }
    // 配置项目的拉取仓库
    repositories {
        mavenLocal()
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/groups/public")
            credentials {
                username = "${System.getenv("NEXUS_USERNAME")?:System.getProperty("NEXUS_USERNAME")}"
                password = "${System.getenv("NEXUS_PASSWORD")?:System.getProperty("NEXUS_PASSWORD")}"
            }
            isAllowInsecureProtocol = true
        }
    }
}

/**
 * ==================================================
 * 配置子项目
 * =================================================
 */
configure(kotlinSubProjects) {
    apply {
        plugin("org.gradle.java-library")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.noarg")
        plugin("com.conventions.publish")
        plugin("com.conventions.sonar")
    }

    /**
     * ============================================================
     * java 配置, jdk 源码 文档 , 依赖java插件
     * ============================================================
     */
    java {
        withSourcesJar()
        withJavadocJar()
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(Versions.JDK_VERSION))
        }
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        implementation(platform(project(":junior-parent")))
    }

    /**
     * ============================================================
     * 依赖管理，新版本被 api(platform("xxx")) 替换
     * ============================================================
     */
    dependencyManagement {
        //applyMavenExclusions(false)
        // 生成自定义的Pom , 如果true,会在生成的子项目pom中存在dependencyManagement
        generatedPomCustomization {
            enabled(false)
        }
    }

    /**
     * ============================================================
     * 所有子项目要执行的任务
     * ============================================================
     */
    tasks {
        withType<Jar>() {
            duplicatesStrategy = DuplicatesStrategy.WARN
            manifest {
                attributes(mapOf(
                    "Implementation-Title" to project.name,
                    "Implementation-Version" to rootProject.version,
                    "Created-By" to "${System.getProperty("java.version")} (${System.getProperty("java.specification.vendor")})",
                    "Gradle-Version" to gradle.gradleVersion,
                    "Build-Jdk" to Versions.JDK_VERSION,
                    "Build-Version" to  "${rootProject.version} Build "+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())
                ))
            }
        }
        withType<JavaCompile>() {
            options.encoding = "UTF-8"
            sourceCompatibility = Versions.JDK_VERSION
            targetCompatibility = Versions.JDK_VERSION
        }
        withType<KotlinCompile>() {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = Versions.JDK_VERSION
            }
        }
        withType<Test>() {
            useJUnitPlatform()
        }
    }
}