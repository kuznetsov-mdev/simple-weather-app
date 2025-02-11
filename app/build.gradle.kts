plugins {
    id("android-app-convention")
    alias(libs.plugins.google.secret)
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

android {
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
    implementation(libs.timber)

    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}