description = "junior-bom (Bill of Materials with Dependencies)"

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
    api(platform(project(":junior-parent")))
    constraints {
        val boms = Versions.internalBomModulesName+rootProject.name
        parent!!.allprojects.filter { !boms.contains(it.name) }.sortedBy { "$it.name" }.forEach {
            api(it)
        }
//        api("com")
    }
}