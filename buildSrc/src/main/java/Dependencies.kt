object ApplicationId {
    val id = "bru.oliveir.playground"
}

object Modules {
    val featureMaster = ":features:master"
}

object Versions {
    val compileSdk = 29
    val minSdk = 21
    val targetSdk = 29
    val gradle = "3.4.1"
    val kotlin = "1.3.41"
    val koin = "2.0.1"
    val appCompat = "1.0.2"
    val junit = "4.12"
    val androidTestRunner = "1.2.0"
    val espresso = "3.2.0"
    val glide = "4.9.0"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object Libraries {
    val koin = "org.koin:koin-android:${Versions.koin}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object AndroidLibraries {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}