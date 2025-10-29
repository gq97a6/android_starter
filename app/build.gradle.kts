import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization") version "2.2.0"
}

android {
    namespace = "com.example.starter"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.starter"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isDebuggable = true
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.fromTarget("11")
            freeCompilerArgs.add("-Xopt-in=androidx.compose.material3.ExperimentalMaterial3ExpressiveApi")
            freeCompilerArgs.add("-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api")
            freeCompilerArgs.add("-Xopt-in=kotlin.time.ExperimentalTime")
            freeCompilerArgs.add("-Xopt-in=kotlin.uuid.ExperimentalUuidApi")
        }
    }
}

//noinspection UseTomlInstead
dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    //Compose
    implementation(platform("androidx.compose:compose-bom:2025.10.01"))
    implementation("androidx.activity:activity-compose:1.11.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation:1.9.4")
    implementation("androidx.compose.foundation:foundation-layout:1.9.4")

    //Navigation 3
    implementation("androidx.navigation3:navigation3-runtime:1.0.0-1.0.0-alpha02")
    implementation("androidx.navigation3:navigation3-ui:1.0.0-1.0.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-viewmodel-navigation3:1.0.0-alpha04")
    implementation("androidx.compose.material3.adaptive:adaptive:1.2.0")

    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")

    //Material 3
    implementation("androidx.compose.material3:material3:1.5.0-alpha07")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.ui:ui:1.9.4")

    //Room
    implementation("androidx.room:room-runtime:2.8.3")
    ksp("androidx.room:room-compiler:2.8.3")
    implementation("androidx.room:room-ktx:2.8.3")
    testImplementation("androidx.room:room-testing:2.8.3")

    //Tests
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}