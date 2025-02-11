import AndroidConst.COMPILE_JDK_VERSION
import gradle.kotlin.dsl.accessors._f2f731efb6df09b1e7770b63a45cad96.implementation
import util.baseConfig
import util.libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android{
    baseConfig()

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = COMPILE_JDK_VERSION
        targetCompatibility = COMPILE_JDK_VERSION
    }

    kotlinOptions {
        jvmTarget = AndroidConst.JVM_TARGET
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}