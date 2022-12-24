plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.justadeveloper96.app"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.justadeveloper96.app"
        minSdk = 21
        targetSdk = 32
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(AndroidDependencies.AndroidX.core)
    implementation(AndroidDependencies.AndroidX.appCompat)
    implementation(AndroidDependencies.Material.core)
    implementation(AndroidDependencies.AndroidX.constraintLayout)
    implementation(project(":feature-auth"))
}