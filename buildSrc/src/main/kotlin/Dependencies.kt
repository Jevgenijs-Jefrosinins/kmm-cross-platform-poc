object Dependencies {

    // Kotlin
    const val kotlinSerializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerialization}"

    // Compose
    const val composeUI = "androidx.compose.ui:ui:${Versions.composeUI}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.composeUI}"
    const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUI}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.composeFoundation}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"

    // Ktor
    const val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorClientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorClientOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
    const val ktorClientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
    const val ktorClientCio = "io.ktor:ktor-client-cio:${Versions.ktor}"
    const val ktorAuth = "io.ktor:ktor-client-auth:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"

    // SQLDelight
    const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    const val sqlDelightCoroutinesExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    const val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"

    // Kodein
    const val kodeinDI = "org.kodein.di:kodein-di:${Versions.kodein}"
    const val kodeinDIAndroidCore = "org.kodein.di:kodein-di-framework-android-core:${Versions.kodein}"
    const val kodeinDIAndroidSupport = "org.kodein.di:kodein-di-framework-android-support:${Versions.kodein}"
    const val kodeinDIAndroidX = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"

    // Test
    const val jUnit4 = "junit:junit:${Versions.jUnit4}"
    const val androidjUnitExt = "androidx.test.ext:junit:${Versions.androidjUnitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val ktorMockClient = "io.ktor:ktor-client-mock:${Versions.ktor_mock}"
    const val ktorMockClientAndroid = "io.ktor:ktor-client-mock-jvm:${Versions.ktor_mock}"

}

object Versions {

    // Gradle
    const val kotlinSerializationPlugin = "1.8.10"
    const val kotlinMultiplatform = "1.8.10"

    // Gradle / Android
    const val androidApp = "7.4.0"
    const val androidLibrary = "7.4.0"
    const val kotlinAndroid = "1.8.10"
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
    const val jvmTarget = "1.8"
    const val composeCompilerExtension = "1.4.4"

    // Kotlin
    const val kotlinSerialization = "1.4.1"

    // Compose
    const val composeUI = "1.4.0"
    const val composeFoundation = "1.4.0"
    const val composeMaterial = "1.4.0"
    const val activityCompose = "1.7.0"

    // Ktor
    const val ktor = "2.2.4"
    const val ktor_mock = "2.2.4"

    // Kodein
    const val kodein = "7.12.0"

    // SQLDelight
    const val sqlDelightPlugin = "1.5.3"
    const val sqlDelight = "1.5.3"

    // Test
    const val jUnit4 = "4.13.1"
    const val androidjUnitExt = "1.1.2"
    const val espressoCore = "3.3.0"

}