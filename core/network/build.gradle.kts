plugins {
    id("android-lib-convention")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "ru.sandbox.swa.network"
}

dependencies {
    //Kotlinx serialization
    implementation(libs.kotlinx.serialization.json)
    //OkHttp
    implementation(libs.logging.interceptor)
    //Moshi
    implementation(libs.moshi.moshi)
    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.codegen.ksp)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
