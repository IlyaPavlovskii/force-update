plugins {
    id("android-app-convention")
}

android {
    namespace = "io.github.ilyapavlovskii.kmm.change.theme.sample"
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
    implementation(libs.io.github.ilyapavlovskii.kmm.koin)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)
    implementation(project(":change-theme-android-presentation"))
    implementation(project(":change-theme-domain"))
    implementation(project(":sample-app-ui"))

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}