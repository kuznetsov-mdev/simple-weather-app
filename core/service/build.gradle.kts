plugins {
    id("android-lib-convention")
    alias(libs.plugins.devtools.ksp)
}

dependencies {
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}