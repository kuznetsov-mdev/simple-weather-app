plugins {
    id("jvm-convention")
}

dependencies {
    implementation(projects.domain)
    implementation(projects.network)
}