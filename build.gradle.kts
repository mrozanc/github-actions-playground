plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`
}

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(platform(libs.kotlin.bom))
    implementation(libs.kotlin.stdlib)

    testImplementation(platform(libs.kotlin.bom))
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.kotlin.test)
    testRuntimeOnly(libs.junit.platform.launcher)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/mrozanc/github-actions-playground")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
