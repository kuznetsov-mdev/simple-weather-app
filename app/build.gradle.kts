plugins {
    id("android-app-convention")
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
}