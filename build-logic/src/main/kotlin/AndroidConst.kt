import org.gradle.api.JavaVersion

object AndroidConst {
    const val NAMESPACE = "ru.sandbox.swa"
    const val COMPILE_SKD = 33
    const val MIN_SKD = 29
    val COMPILE_JDK_VERSION = JavaVersion.VERSION_11
    const val KOTLIN_JVM_TARGET = "11"
}