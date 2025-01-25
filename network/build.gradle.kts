plugins {
    id("jvm-convention")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.devtools.ksp)
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
}
