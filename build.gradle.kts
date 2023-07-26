
allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.20.0")
        classpath("com.android.tools.build:gradle:7.3.1")
    }
}

plugins {
    kotlin("multiplatform") version "1.8.20" apply false
    id("com.louiscad.complete-kotlin") version "1.1.0"
}

subprojects {
    group = "com.github.davidepianca98"
    val libraryVersion = "0.4.1"
    version = System.getenv("GITHUB_REF")?.split('/')?.last() ?: libraryVersion

}
