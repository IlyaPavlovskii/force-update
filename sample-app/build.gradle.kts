plugins {
    id("android-app-convention")
}

android {
    namespace = "io.github.ilyapavlovskii.kmm.force.update.sample"
    defaultConfig {
        applicationId = "io.github.ilyapavlovskii.kmm.change.theme.sample"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.appcompat)

    implementation(project(":force-update-domain"))
    implementation(project(":force-update-android-compose-presentation"))
    implementation(project(":sample-app-ui"))

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
