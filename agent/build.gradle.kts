import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.dazecake.autodroidx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dazecake.autodroidx"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.register<Copy>("makeJar") {
//    from("build/intermediates/packaged-classes/debug/classes.jar")
    from("build/tmp/kotlin-classes/debug/com/dazecake/autodroidx/MainKt.class")
    into("build/libs")
    rename { "autodroidx-agent.jar" }
}.dependsOn("build")