plugins {
    id("android-app-convention")
    alias(libs.plugins.google.secret)
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.sandbox.swa"
    defaultConfig {
        applicationId = "ru.sandbox.swa"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.theme)
    implementation(projects.presentation)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
}