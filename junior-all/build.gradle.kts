description = "junior (Bill of Materials with Dependencies)"

plugins {
    id("com.conventions.publish")
}

// 允许定义platform依赖项
javaPlatform {
    allowDependencies()
}

// 定义依赖版本
dependencies{
    constraints {
        val boms = listOf("junior-bom","junior-all","junior-parent","junior")
        parent!!.allprojects.filter { !boms.contains(it.name) }.sortedBy { "$it.name" }.forEach {
            api(it)
        }
    }
}