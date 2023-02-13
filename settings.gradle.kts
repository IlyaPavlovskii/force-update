@file:Suppress("UnstableApiUsage")
import java.util.Properties

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    val githubProperties = Properties()
    val propsFile = file("github.properties")
    if (propsFile.isFile) {
        propsFile.inputStream().use { fis -> githubProperties.load(fis) }
    } else {
        githubProperties["github_username"] = System.getenv("GITHUB_USERNAME")
        githubProperties["github_password"] = System.getenv("GITHUB_PASSWORD")
    }
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/IlyaPavlovskii/koin-v3-utils")
            credentials {
                username = githubProperties.getProperty("github_username")
                password = githubProperties.getProperty("github_password")
            }
        }
    }
}

includeBuild("build-logic")

include(":change-theme-android-compose-presentation")
include(":change-theme-domain")
include(":sample-app")
include(":sample-app-ui")
