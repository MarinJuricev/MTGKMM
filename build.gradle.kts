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
    // optional: limit format enforcement to just the files changed by this feature branch
    ratchetFrom 'origin/main'

    format 'misc', {
    // define the files to apply `misc` to
    target '*.gradle', '*.md', '.gitignore'

    // define the steps to apply to those files
    trimTrailingWhitespace()
    indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
    endWithNewline()
}
    java {
        // don't need to set target, it is inferred from java

        // apply a specific flavor of google-java-format
        googleJavaFormat('1.8').aosp().reflowLongStrings()
        // make sure every file has the following copyright header.
        // optionally, Spotless can set copyright years by digging
        // through git history (see "license" section below)
        licenseHeader '/* (C)$YEAR */'
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}