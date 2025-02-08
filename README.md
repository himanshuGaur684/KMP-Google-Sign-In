# Google Sign-In with Kotlin Multiplatform Mobile (KMP)

This repository contains the complete implementation of Google Sign-In for both Android and iOS using Kotlin Multiplatform Mobile (KMP). The project is built as part of a YouTube tutorial, demonstrating how to integrate Google authentication seamlessly across platforms.

## 🚀 Features
- Google Sign-In for Android & iOS
- Kotlin Multiplatform Mobile (KMP) implementation
- Shared business logic in Kotlin
- Platform-specific authentication handling
- Modern and clean architecture

## 📺 YouTube Tutorial
Watch the full tutorial on YouTube to understand the step-by-step implementation:  
🔗 [YouTube Video Link](#) (Replace with actual link when available)

## 🛠️ Technologies Used
- **Kotlin Multiplatform Mobile (KMP)**
- **Jetpack Compose** (Android UI)
- **SwiftUI** (iOS UI)
- **Google Sign-In SDK** (Android & iOS)
- **Ktor Client** (For networking, if required)

## 📲 Setup Instructions

### Prerequisites
- Android Studio with Kotlin Multiplatform Plugin
- Xcode (for iOS development)
- Google Developer Console account
- Firebase project set up

### Steps
1. **Clone the repository:**
   ```sh
   git clone https://github.com/himanshuGaur684/google-signin-kmp.git
   cd google-signin-kmp
   ```
2. **Set up Firebase for Android & iOS:**
   - **For Android:**
     1. Go to [Firebase Console](https://console.firebase.google.com/).
     2. Create a new project or use an existing one.
     3. Add an Android app and register it with your package name.
     4. Download the `google-services.json` file and place it inside `androidApp/app`.
     5. Add the Firebase dependencies in `build.gradle.kts`.
   - **For iOS:**
     1. In Firebase Console, add an iOS app and register it with your bundle identifier.
     2. Download the `GoogleService-Info.plist` file.
     3. Place it inside the `iosApp` in Xcode.
     4. Add necessary Firebase SDK dependencies in your `Podfile` and run `pod install`.
3. **Run the project:**
   - **Android:** Run from Android Studio.
   - **iOS:** Open the `iosApp` in Xcode and run on a simulator or device.

## 🔥 Contributions
Feel free to contribute by submitting issues or pull requests! 

---
Made with ❤️ by [Himanshu Gaur](https://github.com/himanshuGaur684)

