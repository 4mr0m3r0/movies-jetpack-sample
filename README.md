# Movies

![State](https://img.shields.io/badge/kotlin-v1.9.20-blueviolet)
![State](https://img.shields.io/badge/gradle-v8.1.0-blue)
![State](https://img.shields.io/badge/Detekt-passing-brightgreen)
![State](https://img.shields.io/badge/UnitTest-incomplete-red)

## 🚧 👷🏗️  Under Modifications  🔨👷 🚧

# Table of Contents

1. [Description](#description)
   1. [Screenshots](#screenshots)
   2. [Flowchart](#flowchart)
   3. [Skills you may find](#skills-you-may-find)
   4. [Design Patterns implemented](#design-patterns-implemented)
   5. [Domain model](#domain-model)
   6. [Architecture](#architecture)
2. [Resources](#resources)
3. [Community](#community)
4. [Additional Android Samples](#additional-android-samples)

# Description

This is a sample project with the main objective of integrating [Jetpack components](https://developer.android.com/jetpack) 
as much as possible in a single app.  
Additionally, the project try to implement ideas from Domain-Drive Design, Design Patterns, and 
Clean Architecture mainly focused on the Dependency Inversion principle.  


The app topic is Movies and you may find functionalities such as: 
* search movies by name. 
* see the movie extra details. 
* mark the movie as favorite. 
* listing favorite movies.

## Jetpack components map
Legend:  
🟩 Implemented in the app.  
🟨 Implementing (WIP).  
⬜ Not yet implemented.

![Default Screen](diagrams/jetpack-mindmap.png)

## Screenshots

![Default Screen](screenshots/default.png "Default Screen")
![Search Screen](screenshots/searching.png "Search Screen")
![Detail Screen](screenshots/detail.png "Detail Screen")
![Add to Favorite Screen](screenshots/add_favorite.png "Add to Favorite Screen")
![Menu Screen](screenshots/menu.png "Menu Screen")
![Favorites Screen](screenshots/favorites.png "Favorites Screen")

## Flowchart

```mermaid
graph LR
A[Navigation Drawer] --> B[Find Movie Screen]
A --> G
B -- input search --> C{Any Result?}
C -- Yes --> D[Listing Movies Screen]
C -- No --> E[Empty Screen]
D -- select --> F[Detail Screen]
F -- add to favorites --> F
G[Favorite Screen]
```

## Skills you may find

| Jetpack       | Kotlin & Quality    | Dependency Management | Others        | Testing           |
|---------------|---------------------|-----------------------|---------------|-------------------|
| `Compose`     | `Coroutines`        | `Version Catalogs`    | `Landscapist` | `MockK`           |
| `WorkManager` | `Asynchronous Flow` | `TOML`                | `Material 3`  | `ComposeTestRule` |
| `Hilt`        | `Detekt`            | `Gradle Kotlin DSL`   | `Retrofit`    |                   |
| `Room`        | `Ktlint`            |                       | `OkHttp`      |                   |
| `Paging`      |                     |                       | `Timber`      |                   |
| `Navigation`  |                     |                       | `Lottie`      |                   |

## Design Patterns implemented

| Creational | Structural | Behavioral              |
|------------|------------|-------------------------|
| Singleton  | Facade     | Command                 |
|            |            | Chain of Responsibility |
|            |            | State                   |

## Domain Model
The Domain Model pattern is shown here in a very simple way.   
This project is trying to follow the ideas explained in [Domain-Driven Design book of Eric Evans](https://a.co/d/hnmkp9y).  
Yet, there are only a few entities, so far, such as: `Movie` and `TomatoMeter`.

## Architecture
It's strongly recommended to read [Clean Architecture book of Robert C. Martin](https://a.co/d/2zkv7YX) 
for a better understanding and avoiding misconceptions out there.   
As a glimpse, read Clean Code blog: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
![CleanArchitecture](screenshots/CleanArchitecture.jpg "Clean Architecture")

# Resources
![Default Screen](https://blog.jetbrains.com/wp-content/uploads/2019/01/kotlin-2.svg)
* 📝 **Kotlin Docs:** https://kotlinlang.org/docs/home.html
* 🚀 **Kotlin Release:** https://github.com/JetBrains/kotlin/releases
* 📣 **Kotlin Blog:** https://blog.jetbrains.com/kotlin/
* 🎥 **Kotlin Youtube Channel:** https://www.youtube.com/channel/UCP7uiEZIqci43m22KDl0sNw
* 🤖 **Kotlin Reddit:** https://www.reddit.com/r/Kotlin/
* 🤯 **Kotlin StackOverflow:** https://stackoverflow.com/questions/tagged/kotlin
* 🗺️ **Kotlin Community:** https://kotlinlang.org/community/

![Default Screen](https://developer.android.com/static/images/logos/android.svg)

* 📝 **Platform Architecture:** https://developer.android.com/guide/platform
* 👩‍💻👨‍💻 **Android Developers:** https://developer.android.com/
* **Android Jetpack:** https://developer.android.com/jetpack
* **Sunflower:** https://github.com/android/sunflower
* **Compose Samples:** https://github.com/android/compose-samples

# Community
* **Droidcon:** www.droidcon.com
* **Android Developers:** https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg

# Additional Android Samples
For more samples in this series of Android Development, please, feel free to check them. Each one of them 
cover a specific topic.
* **Modularization by layers.** _Skills: MVI, RxJava._  
  👉 https://github.com/4mr0m3r0/movies-mvi-sample
* **Modularization by features.** _Skills: MVI, Coroutines, Flow._  
  👉 https://github.com/4mr0m3r0/movies-modularization-sample
* **Implementing a Design System.** _Skills: Jetpack Compose, Atomic Design Methodology._  
  👉 https://github.com/4mr0m3r0/atomic-design-sample
* **Android Services.** _Skills: Services, Broadcast Receivers, Content Providers._  
  👉 https://github.com/4mr0m3r0/android-services-sample
