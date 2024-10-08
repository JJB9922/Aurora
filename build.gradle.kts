plugins {
    application
    kotlin("jvm") version "1.9.24"
}

application {
    mainClass = "processing.Hello"
}

dependencies {

    implementation("org.processing:core:3.3.7")
}

repositories {
    mavenCentral()
}

val javaVersion = 21
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}
tasks.withType(JavaCompile::class) {
    options.release.set(javaVersion)
}
