plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "ye.catisgoal.dhhtyard"
    compileSdk = 34

    defaultConfig {
        applicationId = "ye.catisgoal.dhhtyard"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
        sourceSets {
            getByName("debug").assets.srcDirs(files("$projectDir/schemas"))
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("io.coil-kt:coil-compose:2.5.0")


    implementation("io.ktor:ktor-client-core:2.2.2")
    implementation("io.ktor:ktor-client-android:2.2.2")
    implementation("io.ktor:ktor-client-logging:2.2.2")
    implementation("io.ktor:ktor-client-serialization:2.2.2")
    implementation("io.ktor:ktor-client-content-negotiation:2.2.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.26.3-beta")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.26.2-beta")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha13")
    implementation("androidx.compose.material:material-icons-extended:1.5.4")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("org.jsoup:jsoup:1.16.1")

    implementation("com.google.accompanist:accompanist-pager:0.25.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.25.0")

    implementation("androidx.datastore:datastore-preferences:1.0.0-alpha01")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
}