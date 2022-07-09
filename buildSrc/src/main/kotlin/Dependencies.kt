object Versions {
    const val androidMinSdk = 23
    const val androidCompileSdk = 32
    const val androidTargetSdk = androidCompileSdk

    const val kotlinCoroutines = "1.6.3"
    const val kotlinxSerialization = "1.3.3"

    const val koin = "3.2.0"
    const val ktor = "2.0.3"
    const val sqlDelight = "1.5.3"

    const val compose = "1.3.0-alpha01"
    const val composeCompiler = "1.2.0"
    const val navCompose = "2.5.0"
    const val coilCompose = "2.1.0"
    const val accompanist = "0.24.13-rc"

    const val material = "1.4.0"
    const val activityCompose = "1.6.0-alpha05"
    const val lifecycleKtx = "2.6.0-alpha01"
    const val lifecycleRuntimeKtx = lifecycleKtx
    const val lifecycleViewModelKtx = lifecycleKtx

    const val turbine = "0.8.0"

    const val settings = "1.0.0-alpha01"

    const val gradleVersionsPlugin = "0.42.0"

}

object Dependencies {

    object Kotlinx {
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    }

    object Compose {
        const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"

        const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
        const val accompanistPlaceholder = "com.google.accompanist:accompanist-placeholder-material:${Versions.accompanist}"
    }

    object AndroidX {
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val testJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    }

    object SqlDelight {
        const val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
        const val coroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
    }

    object Gradle {
        const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"
    }

    object Test {
        const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    }

    object Settings {
        const val multiplatform = "com.russhwolf:multiplatform-settings:${Versions.settings}"
    }
}