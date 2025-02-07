plugins {
    id("android-lib-convention")
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

dependencies {
    implementation(libs.androidx.compose.navigation)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}