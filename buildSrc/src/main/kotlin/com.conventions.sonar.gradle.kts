plugins {
	`java-library`
	id("org.sonarqube")
	id("jacoco")
}

jacoco {
	toolVersion = "0.8.8"
//	reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
	reportsDirectory.set(file("$buildDir/reports/jacoco"))
}


tasks.jacocoTestReport {
	reports {
		xml.required.set(false)
		csv.required.set(false)
		html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
	}
}

sonarqube {
	properties {
		property("sonar.sourceEncoding","UTF-8")
		property("sonar.sources","src/main/kotlin")
//		property "sonar.exclusions", "**/*Test.java"
//		property "sonar.core.codeCoveragePlugin","jacoco"
//		//覆盖报告绝对路径 需要保证路径下有生成的报告report.html
//		property "sonar.coverage.jacoco.xmlReportPaths","${project.projectDir}/core/build/reports/coverage/debug/report.xml"


//		property("sonar.host.url","http://192.168.6.101:9000/")
//		property("sonar.jdbc.url", "jdbc:mysql://192.168.6.101:3306/sonar")
//		property("sonar.jdbc.driverClassName", "com.mysql.jdbc.Driver")
//		property("sonar.jdbc.username", "root")
//		property("sonar.jdbc.password", "")
//		property("sonar.sourceEncoding", "UTF-8")
//		property("sonar.login", "admin")
//		property("sonar.password", "")
//		property("sonar.forceAuthentication", "false")
//		property("sonar.groovy.jacoco.reportPath", "${project.buildDir}/jacoco/test.exec")
//		property("sonar.jacoco.reportPaths", "${project.buildDir}/jacoco/test.exec")
	}
}