/**
 * @author yusuf.onder
 * Created on 3.01.2022
 */

object Libs {

    const val gradle: String = "com.android.tools.build:gradle:" + Versions.gradle
    const val gradlePlugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" + Versions.gradlePlugin

    //Network
    const val gson: String = "com.google.code.gson:gson:" + Versions.gson
    const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
    const val converter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
    const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http

    //Logging
    const val timber = "com.jakewharton.timber:timber:" + Versions.timber

    //Coroutines
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.coroutines

    //Compose
    const val composeUi = "androidx.compose.ui:ui:" + Versions.compose
    const val composeMaterial = "androidx.compose.material:material:" + Versions.compose
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:" + Versions.compose
    const val composeActivity = "androidx.activity:activity-compose:" + Versions.composeActivity
    const val composeNavigation = "androidx.navigation:navigation-compose:" + Versions.composeNavigation

    //Lifecycle AndroidX
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.lifecycle

    //Maps
    const val googleMaps = "com.google.android.libraries.maps:maps:" + Versions.googleMaps
    const val mapKtx = "com.google.maps.android:maps-v3-ktx:" + Versions.mapKtx

    //Fragment
    const val fragment = "androidx.fragment:fragment:" + Versions.fragment

    //Dagger Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:" + Versions.hilt
    const val hiltCompiler= "com.google.dagger:hilt-compiler:" + Versions.hilt
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:" + Versions.hiltCompose
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt

    //AndroidX
    const val coreKtx = "androidx.core:core-ktx:" + Versions.coreKtx
    const val appCompat = "androidx.appcompat:appcompat:" + Versions.appCompat
    const val material = "com.google.android.material:material:" + Versions.appCompat

    //Test
    const val junit = "junit:junit:" + Versions.junit
    const val junitExt = "androidx.test.ext:junit:" + Versions.junitExt
    const val espresso = "androidx.test.espresso:espresso-core:" + Versions.espresso

}