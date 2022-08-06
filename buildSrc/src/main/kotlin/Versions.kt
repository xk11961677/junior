// 统一管理依赖库版本
object Versions {
    val internalBomModulesName = listOf("junior-bom","junior-parent")
    const val JDK_VERSION = "17"
    const val KOTLIN_VERSION = "1.7.0"


    const val SPRING_BOOT_VERSION = "2.7.2"
    const val SPRING_FRAMEWORK_BOM_VERSION = "5.3.18"
    const val DUBBO_VERSION = "3.0.10"
    const val JACKSON_BOM_VERSION = "2.13.2"

    const val SPRING_DEPENDENCY_MANAGEMENT_VERSION =  PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    const val SONARQUBE_VERSION = PluginVersions.SONARQUBE_VERSION
}
// 统一管理插件版本
object PluginVersions {
    const val SPRING_DEPENDENCY_MANAGEMENT_VERSION =  "1.0.12.RELEASE"
    const val SONARQUBE_VERSION = "3.4.0.2513"
}
// 统一管理本项目使用的依赖库版本
object DependencieVersions {

}