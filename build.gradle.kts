plugins {
    id("com.diffplug.spotless") version "6.7.2"
}

//TODO Migrate to plugin DSL
buildscript {
    val kotlinVersion: String by project
    val gradleVersion: String by project

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
        classpath("com.android.tools.build:gradle:$gradleVersion")

        with(Dependencies.Gradle) {
            classpath(sqlDelight)
            classpath(gradleVersionsPlugin)
        }
    }
}

spotless {
    kotlin {
        // version, setUseExperimental, userData and editorConfigOverride are all optional
        ktlint("0.45.2")
            .setUseExperimental(true)
            .userData(mapOf("android" to "true"))
            .editorConfigOverride(mapOf("indent_size" to 4))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
