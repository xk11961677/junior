dependencies {
    api(project(":junior-migration-base"))
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.slf4j:slf4j-api")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

description = "junior-migration-flyway description"
