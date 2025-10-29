# Android Starter Project
Starter project for modern Android app written in Kotlin.

### Overview
- MVVM Design Pattern
- Jetpack Compose with Material 3 Expressive
- Local database using Room
- Single Activity with navigation using Navigation 3
- Includes example Material 3 color schemes
- Unit and Android tests support
- Composable previews support
- Kotlin Coroutines support
- Set up without boilerplate XML legacy code

### How to change project name/package?
There are 3 packges in project under these paths:
- `AndroidTestApp`/app/src/main/java/`com/example/starter`
- `AndroidTestApp`/app/src/test/java/`com/example/starter`
- `AndroidTestApp`/app/src/androidTest/java/`com/example/starter`

1. Close Android Studio.
2. Rename project folder (`AndroidTestApp`) to any name.
3. Modify these (`com/example/starter`) folders to match desired packge eg. `com/domain/app`.
4. Open Android Studio.
5. In `settings.gradle` modify `rootProject.name = "AndroidStarterProject"`. \
It does not have to match project folder name.
6. Use `CTRL` `SHIFT` `R` and replace all occurences of `com.example.starter` in whole project with new package.

### How to change app name?
1. In `AndroidManifest.xml` modify `android:label="AndroidStarterProject"`