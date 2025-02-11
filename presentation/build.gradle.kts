plugins {
    id("android-lib-convention")
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

dependencies {
    implementation(projects.domain)
    implementation(projects.theme)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
}