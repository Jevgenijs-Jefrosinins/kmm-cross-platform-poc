plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Versions.androidApp).apply(false)
    id("com.android.library").version(Versions.androidLibrary).apply(false)
    kotlin("android").version(Versions.kotlinAndroid).apply(false)
    kotlin("multiplatform").version(Versions.kotlinMultiplatform).apply(false)
    kotlin("plugin.serialization").version(Versions.kotlinSerializationPlugin).apply(false)
    id("com.squareup.sqldelight").version(Versions.sqlDelightPlugin).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
