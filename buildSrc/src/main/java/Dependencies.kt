object ApplicationId {
    const val id = "bru.oliveir.playground"
}

object Modules {
    const val model = ":data:model"
    const val local = ":data:local"
    const val remote = ":data:remote"
    const val repository = ":data:repository"
    const val featureMaster = ":features:master"
}

object Versions {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val gradle = "3.4.1"
    const val kotlin = "1.3.41"
    const val koin = "2.0.1"
    const val junit = "4.12"
    const val androidTestRunner = "1.2.0"
    const val espresso = "3.2.0"
    const val glide = "4.9.0"
    const val room = "2.1.0"
    const val coroutines = "1.3.0-M2"
    const val appCompat = "1.0.2"
    const val lifecycle = "2.2.0-alpha02"
    const val recyclerView = "1.0.0"
    const val constraintLayout = "1.1.3"
    const val dataBinding = "3.4.1"
    const val gson = "2.8.5"
    const val retrofit = "2.6.0"
    const val retrofitGson = "2.4.0"
    const val okHttp = "3.12.1"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object Libraries {
    // Koin
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    // Room
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    // Retrofit
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object AndroidLibraries {
    // Kotlin
    const val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // Android
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val dataBinding = "androidx.databinding:databinding-compiler:${Versions.dataBinding}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}