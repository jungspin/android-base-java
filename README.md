# Base Project

<aside>
💡 안드로이드 프로젝트 생성 시 필요한 라이브러리와 구조를 미리 정의합니다.
</aside>

## Summary
👉🏻 Language
- java

👉🏻 minSdk
- 21 5.0(Lollipop)

👉🏻 buildFeatures
- viewBinding true
- dataBinding true

## Dependency

    // rxjava2
    implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
    implementation 'io.reactivex.rxjava2:rxjava:2.2.17'

    // retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.9.0'

    // okhttp
    implementation 'com.squareup.okhttp3:okhttp-urlconnection:4.9.2'

    // GSON
    implementation 'com.google.code.gson:gson:2.9.0'

    // ViewModel
    def lifecycle_version = "2.5.0"
    //noinspection GradleDependency
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    //noinspection GradleDependency
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

    // Jetpack Compose Navigation
    def nav_version = "2.4.2"
    // Java language implementation
    //noinspection GradleDependency
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    //noinspection GradleDependency
    implementation "androidx.navigation:navigation-ui:$nav_version"
    // Feature module Support
    //noinspection GradleDependency
    implementation "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"
    // Testing Navigation
    //noinspection GradleDependency
    androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
