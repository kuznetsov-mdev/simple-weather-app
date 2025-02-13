import AndroidConst.COMPILE_JDK_VERSION
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
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}