plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.accenture.kmmpoc.android"
    compileSdk = Versions.compileSdk
    defaultConfig {
        applicationId = "com.accenture.kmmpoc.android"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompilerExtension
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
}

dependencies {
    api(project(":presentation"))
    api(project(":shared"))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUITooling)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.activityCompose)

    implementation(Dependencies.kodeinDIAndroidCore)
    implementation(Dependencies.kodeinDIAndroidX)
}