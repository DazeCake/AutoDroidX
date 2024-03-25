import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
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

        @Suppress("UnstableApiUsage")
        externalNativeBuild {
            cmake {
                cppFlags("-std=c++17")
                abiFilters("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
            }
        }
    }
    // make sure java compile is executed before ndk compile
    // because we rely on Jenny generating cpp code
    applicationVariants.all { variant ->
        variant.externalNativeBuildProviders.forEach {
            it.configure {
                it.dependsOn(variant.javaCompileProvider.name)
            }
        }
        return@android
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
            path("src/main/cpp/CMakeLists.txt")
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

    // Jenny https://github.com/LanderlYoung/Jenny
    compileOnly(libs.jenny.annotation)
    kapt(libs.jenny.compiler)
}

kapt {
    arguments {
        // pass arguments to jenny
        // arg("jenny.threadSafe", "false")
        arg("jenny.errorLoggerFunction", "jennySampleErrorLog")
        // arg("jenny.outputDirectory", project.buildDir.absolutePath+"/test")
        arg("jenny.headerOnlyProxy", "true")
        arg("jenny.useJniHelper", "true")
        // arg("jenny.fusionProxyHeaderName", "JennyFusionProxy.h")
    }
}

tasks.register<Copy>("copyGeneratedCpp") {
    val generatedDir = "generated/source/kapt/debug"
    val buildDir = project.layout.buildDirectory.get().asFile
    copy {
        from(File(buildDir, "${generatedDir}/jenny/proxy"))
        into(project.file("src/main/cpp/gen"))
    }
//    copy {
//        from(File(buildDir, "${generatedDir}/jenny/glue/header"))
//        into(project.file("src/main/cpp"))
//    }
}

tasks.register<Exec>("pushAgent") {
    val s = File.separator
    commandLine(
        "adb",
        "push",
        "build${s}outputs${s}apk${s}debug${s}agent-debug.apk",
        "/data/local/tmp/autodroidx-agent.jar",
    )
}.dependsOn("build")

tasks.register<Exec>("runAgent") {
    commandLine(
        "adb",
        "shell",
        "CLASSPATH=/data/local/tmp/autodroidx-agent.jar",
        "app_process",
        "/",
        "com.dazecake.autodroidx.Main"
    )
}.dependsOn("pushAgent")

afterEvaluate {
    // copy file to source after jenny generate
    tasks.named("kaptDebugKotlin") {
        finalizedBy("copyGeneratedCpp")
    }
}