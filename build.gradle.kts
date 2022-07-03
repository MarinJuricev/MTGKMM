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

//configure<com.diffplug.gradle.spotless.SpotlessExtension> {
//    kotlin {
//        // version, setUseExperimental, userData and editorConfigOverride are all optional
//        ktlint("0.45.2")
//            .setUseExperimental(true)
//            .userData(mapOf("android" to "true"))
//            .editorConfigOverride(mapOf("indent_size" to 4))
//    }
//    kotlinGradle {
//        target("*.gradle.kts") // default target for kotlinGradle
//        ktlint() // or ktfmt() or prettier()
//    }
//}q

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target ("**/*.kt")
            ktfmt().googleStyle()
            ktlint("0.45.2")
                .setUseExperimental(true)
                .userData(mapOf("android" to "true"))
                .editorConfigOverride(
                    mapOf(
                        "indent_size" to 4,
                        "max_line_length" to 120,
                    )
                )
        }

        kotlinGradle {
            target("*.gradle.kts") // default target for kotlinGradle
            ktlint() // or ktfmt() or prettier()
        }

        format ("xml") {
            target ("**/*.xml")
            prettier(mapOf("prettier" to "2.0.5", "@prettier/plugin-xml" to "0.13.0")).config(mapOf("parser" to "xml", "tabWidth" to 4))
        }
    }
}