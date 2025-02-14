plugins {
    id("android-lib-convention")
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.sandbox.swa.core.service"
}

dependencies {
    implementation(projects.domain)
    //Coroutines
    implementation(libs.kotlinx.coroutines.core)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}