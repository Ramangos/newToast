Installation
Step 1: Add JitPack to your Project-Level build.gradle or settings.gradle
Add the JitPack repository to your project-level Gradle file:

gradle
Copy code
repositories {
    maven { url 'https://jitpack.io' }
}
Step 2: Add the Dependency
Include the library in your app-level build.gradle file:

gradle
Copy code
dependencies {
    implementation 'com.github.Ramangos:newToast:12.0'
}
