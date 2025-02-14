plugins {
    id("android-lib-convention")
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.sandbox.swa.data"
}

dependencies {
    implementation(projects.domain)
    implementation(projects.core.network)
    implementation(projects.core.storage)
    implementation(projects.core.service)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}