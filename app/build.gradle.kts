plugins {
    id("android-app-convention")
}

android {

    defaultConfig {
        applicationId = "ru.sandbox.swa"
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
