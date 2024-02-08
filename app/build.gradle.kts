import android.annotation.SuppressLint
import de.honoka.gradle.buildsrc.Versions

plugins {
    @Suppress("RemoveRedundantQualifierName")
    val versions = de.honoka.gradle.buildsrc.Versions.AndroidApp
    //plugins
    id("com.android.application") version versions.android
    kotlin("android") version versions.kotlin
}

android {
    namespace = "de.honoka.lavender.android"
    compileSdk = 33

    defaultConfig {
        applicationId = "de.honoka.lavender.android"
        minSdk = 26
        @SuppressLint("OldTargetApi")
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0-dev"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            @Suppress("UnstableApiUsage")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = sourceCompatibility
    }

    kotlinOptions {
        jvmTarget = compileOptions.sourceCompatibility.toString()
    }
}

dependencies {
    implementation(project(":app-api"))
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("de.honoka.sdk:honoka-android-utils:${Versions.AndroidApp.honokaAndroidUtils}")
    implementation("cn.hutool:hutool-all:5.8.18")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}