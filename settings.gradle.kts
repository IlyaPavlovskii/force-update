@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

// rootProject.name = "change-theme-domain"

includeBuild("build-logic")

include(":change-theme-android-presentation")
include(":change-theme-domain")
include(":sample-app")
include(":sample-app-ui")
