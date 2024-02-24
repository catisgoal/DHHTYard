buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    }
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("com.android.library") version "8.2.0" apply false
}