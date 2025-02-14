plugins {
    id("android-lib-convention")
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.sandbox.swa.core.storage"
}

dependencies {
    //Kotlinx serialization
    implementation(libs.kotlinx.serialization.json)
    //Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    //ProtoDataStore
    implementation(libs.androidx.datastore)
}