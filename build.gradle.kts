import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
	id("com.coditory.integration-test") version "1.4.5"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	idea
}

group = "org.mibe.tribute"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

val asciidoctorExt: Configuration by configurations.creating

val kotestVersion by properties
val snippetsDir = file(property("snippetsDirPath")!!)

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.liquibase:liquibase-core")
	developmentOnly("com.h2database:h2:2.1.214")

	asciidoctorExt("org.springframework.restdocs:spring-restdocs-asciidoctor:3.0.0")
	testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
	testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.integrationTest  {
	outputs.dir(snippetsDir)
}

tasks.asciidoctor {
	inputs.dir(snippetsDir)
	configurations("asciidoctorExt")
	dependsOn(tasks.test, tasks.integrationTest )
}

idea {
	module {
		testSources.from(sourceSets["integration"].kotlin.srcDirs)
	}
}