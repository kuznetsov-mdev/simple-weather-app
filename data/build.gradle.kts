plugins {
    id("jvm-convention")
}

dependencies {
    implementation(projects.core.storage)
    implementation(projects.core.network)
}