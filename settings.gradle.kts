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
    }
}

includeBuild("build-logic")

include(":force-update-android-compose-presentation")
include(":force-update-domain")
include(":sample-app")
include(":sample-app-ui")
