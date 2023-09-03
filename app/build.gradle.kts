plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //kapt를 사용하기 위해서 추가
    id("kotlin-kapt")
}

val navVersion: String by rootProject.extra
val coreKtxVersion: String by rootProject.extra
val appCompatVersion: String by rootProject.extra
val materialVersion: String by rootProject.extra
val constraintLayoutVersion: String by rootProject.extra
val junitVersion: String by rootProject.extra
val androidJUnitVersion: String by rootProject.extra
val espressoCoreVersion: String by rootProject.extra
val timberVersion: String by rootProject.extra
val coilVersion: String by rootProject.extra
val glideVersion: String by rootProject.extra

android {
    namespace = "com.shoppi.app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.shoppi.app"
        minSdk = 27
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "17"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }
}



dependencies {
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$androidJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoCoreVersion")

    // Timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Coil
    implementation("io.coil-kt:coil:$coilVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")

    // GSON
    implementation("com.google.code.gson:gson:2.8.8")

    //fragment-ktx
    implementation("androidx.fragment:fragment-ktx:1.4.1")
}