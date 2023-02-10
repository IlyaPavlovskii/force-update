@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

val versionSuffix = "-SNAPSHOT"
project.version = project.version.toString() + versionSuffix

mavenPublishing {
    //publishToMavenCentral(SonatypeHost.S01)

    coordinates(
        groupId = project.group.toString(),
        artifactId = project.name,
        version = project.version.toString()
    )

    pom {
        name.set("ipavlovskii-change-theme")
        description.set("Simple KMM library to change application theme")
        inceptionYear.set("2023")
        url.set("https://github.com/IlyaPavlovskii/change-theme")
        licenses {
            license {
                name.set("Apache 2.0 License")
                url.set("https://github.com/IlyaPavlovskii/change-theme/blob/master/LICENSE.md")
                distribution.set("https://github.com/IlyaPavlovskii/change-theme/blob/master/LICENSE.md")
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
            url.set("https://github.com/IlyaPavlovskii/change-theme")
            connection.set("scm:git:github.com/IlyaPavlovskii/change-theme.git")
            developerConnection.set("scm:git:ssh://github.com/IlyaPavlovskii/change-theme.git")
        }
    }

    signAllPublications()
}
