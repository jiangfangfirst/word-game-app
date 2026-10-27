plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.app.pakeplus"
    compileSdk = 34

    /*
    // 因为找不到 pakeplus.keystore 文件，这里已经注释掉自定义签名
    signingConfigs {
        create("release") {
            storeFile = rootProject.file("pakeplus.keystore")
            storePassword = "1024xiaoshen"
            keyPassword = "1024xiaoshen"
            keyAlias = "pakeplus"
        }
    }
    */

    defaultConfig {
        applicationId = "com.oaikes.pakeplus.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.2"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false // 建议关闭混淆，避免 WebView 加载出现莫名其妙的报错
            isShrinkResources = false
            // signingConfig = signingConfigs.getByName("release") // 注释掉
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = false // 建议关闭混淆
            // signingConfig = signingConfigs.getByName("release") // 注释掉
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
