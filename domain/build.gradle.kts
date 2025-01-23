plugins {
    id("jvm-convention")
}

kotlin {
    jvmToolchain(AndroidConst.JAVA_VERSION)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
}