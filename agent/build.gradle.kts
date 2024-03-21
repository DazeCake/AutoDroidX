import com.android.build.gradle.internal.tasks.factory.dependsOn
import java.io.ByteArrayOutputStream

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.dazecake.autodroidx"
    compileSdk = 34

    packaging {
        jniLibs {
            useLegacyPackaging = false
        }
    }

    defaultConfig {
        applicationId = "com.dazecake.autodroidx"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags("-std=c++17")
                abiFilters("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
            }
        }
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
    externalNativeBuild {
        cmake {
            path("CMakeLists.txt")
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

tasks.register<Exec>("runAgent") {
    commandLine(
        "adb",
        "push",
        "$workingDir/build/outputs/apk/debug/agent-debug.apk",
        "/data/local/tmp/autodroidx-agent.jar"
    )
    commandLine(
        "adb",
        "shell",
        "CLASSPATH=/data/local/tmp/autodroidx-agent.jar",
        "app_process",
        "/",
        "com.dazecake.autodroidx.Main"
    )
}.dependsOn("build")