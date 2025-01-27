plugins {
    id("android-lib-convention")
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    //Kotlinx serialization
    implementation(libs.kotlinx.serialization.json)
    //Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}