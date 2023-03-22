@file:Suppress("UnstableApiUsage")

import java.util.Properties

plugins {
    id("com.vanniktech.maven.publish")
}

project.version = project.version.toString()

fun readGithubProperties(): Properties {
    val githubProperties = Properties()
    project.rootProject.file("github.properties")
        .takeIf { file -> file.exists() && file.isFile }
        ?.also { file ->
            file.inputStream().use { fis -> githubProperties.load(fis) }
        } ?: run {
        githubProperties["github_username"] = System.getenv("GITHUB_USERNAME") ?: ""
        githubProperties["github_password"] = System.getenv("GITHUB_PASSWORD") ?: ""
    }
    return githubProperties
}

publishing {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/IlyaPavlovskii/force-update")
            val githubProperties: Properties = readGithubProperties()
            credentials {
                username = githubProperties.getProperty("github_username")
                password = githubProperties.getProperty("github_password")
            }
        }
        mavenLocal()
    }
}

mavenPublishing {
    coordinates(
        groupId = project.group.toString(),
        artifactId = project.name,
        version = project.version.toString()
    )

    pom {
        name.set("ipavlovskii-force-update")
        description.set("Simple KMM library to support force update")
        inceptionYear.set("2023")
        url.set("https://github.com/IlyaPavlovskii/force-update")
        licenses {
            license {
                name.set("Apache 2.0 License")
                url.set("https://github.com/IlyaPavlovskii/force-update/blob/master/LICENSE.md")
                distribution.set("https://github.com/IlyaPavlovskii/force-update/blob/master/LICENSE.md")
            }
        }
        developers {
            developer {
                id.set("Ilia Pavlovskii")
                name.set("Ilia Pavlovskii")
                url.set("trane91666@gmail.com")
            }
        }
        scm {
            url.set("https://github.com/IlyaPavlovskii/force-update")
            connection.set("scm:git:github.com/IlyaPavlovskii/force-update.git")
            developerConnection.set("scm:git:ssh://github.com/IlyaPavlovskii/force-update.git")
        }
    }
}
