package util

import AndroidConst
import com.android.build.gradle.BaseExtension



fun BaseExtension.baseConfig() {
    setCompileSdkVersion(AndroidConst.COMPILE_SKD)

    defaultConfig{
        minSdk = AndroidConst.MIN_SKD
        targetSdk = AndroidConst.TARGET_SDK

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = AndroidConst.COMPILE_JDK_VERSION
        targetCompatibility = AndroidConst.COMPILE_JDK_VERSION
    }
}