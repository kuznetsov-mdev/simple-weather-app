package util

import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

internal fun Project.android(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

internal val Project.libs: LibrariesForLibs
    get() = (this as ExtensionAware).extensions.getByName("libs") as LibrariesForLibs

fun Project.`kotlin`(configure: Action<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension>): Unit =
    (this as ExtensionAware).extensions.configure("kotlin", configure)
