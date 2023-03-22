buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
    dependencies {
        classpath(libs.plugin.kotlin.gradle)
        classpath(libs.plugin.android.gradle)
        classpath(":build-logic")
    }
}

plugins {
    id("configuration-detekt-convention")
}

subprojects {
    val githubProperties = java.util.Properties()
    val propsFile = file("github.properties")
    if (propsFile.isFile) {
        propsFile.inputStream().use { fis -> githubProperties.load(fis) }
    } else {
        githubProperties["github_username"] = System.getenv("GITHUB_USERNAME") ?: ""
        githubProperties["github_password"] = System.getenv("GITHUB_PASSWORD") ?: ""
    }
    apply(plugin = "configuration-ktlint-convention")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://maven.pkg.github.com/IlyaPavlovskii/koin-v3-utils")
            credentials {
                username = githubProperties.getProperty("github_username")
                password = githubProperties.getProperty("github_password")
            }
        }
    }
    group = "io.github.ilyapavlovskii.kmm.force.update"
    version = "2023.03.23"

    setupJavaTarget(this)
}

fun setupJavaTarget(project: Project) {
    project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
    project.tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
