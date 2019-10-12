// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
        @Suppress("UnstableApiUsage")
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.0-beta01")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Deps.kotlinVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
