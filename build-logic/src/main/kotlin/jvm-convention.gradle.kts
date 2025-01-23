import AndroidConst.COMPILE_JDK_VERSION

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

kotlin {
    jvmToolchain(AndroidConst.JAVA_VERSION)
}

java {
    sourceCompatibility = COMPILE_JDK_VERSION
    targetCompatibility = COMPILE_JDK_VERSION
}
