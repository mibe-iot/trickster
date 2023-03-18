plugins {
    java
}

version = "1.0.0"
group = "org.mibe.tribute"

repositories {
    mavenCentral()
}

val integrationTest by sourceSets.creating

configurations[integrationTest.implementationConfigurationName].extendsFrom(configurations.testImplementation.get())
configurations[integrationTest.runtimeOnlyConfigurationName].extendsFrom(configurations.testRuntimeOnly.get())

val integrationTestTask = tasks.register<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = integrationTest.output.classesDirs
    classpath = configurations[integrationTest.runtimeClasspathConfigurationName] +
            integrationTest.output

    shouldRunAfter(tasks.test)
}

tasks.check {
    dependsOn(integrationTestTask)
}

dependencies {
    "integrationTestImplementation"(project)
}