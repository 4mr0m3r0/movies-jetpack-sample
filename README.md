# Movies Demo 
A demo app illustrating Android development with Kotlin, Android Jetpack, Dagger 2, RxKotlin - RxAndroid, Clean Architecture and MVVM

Introduction
------------
This app came from the idea of [movies-clean-architecture][25] project from Pablo Araya (pabloaraya)   
### Functionality
Find movies information using [OMDb API][26]
#### Display Movies
 Display a list of movies searching them by title
#### Movie Detail
 Display a detail from a selected movie on the list. (Not implemented yet)
 
Libraries Used
--------------
 * [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
   multidex and automated testing.
   * [AppCompat][1] - Degrade gracefully on older versions of Android.
   * [Test][4] - An Android testing framework for unit and runtime UI tests.
 * [Architecture][10] - A collection of libraries that help you design robust, testable, and
   maintainable apps. Start with classes for managing your UI component lifecycle and handling data
   persistence.
   * [Data Binding][11] - Declaratively bind observable data to UI elements.
   * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
   * [LiveData][13] - Build data objects that notify views when the underlying database changes.
   * [Navigation][14] - Handle everything needed for in-app navigation.
   * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
   * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
 * [Dagger 2][36] Dependency Injection Framework.
 * Third party
   * [RxKotlin][38] - [RxAndroid][39] Reactive Extensions for Kotlin and Android.
   * [Timber][40] A logger with a small, extensible API which provides utility on top of Android's normal Log class.
   * [Robolectric][41] A unit test framework that de-fangs the Android SDK jar. 
   * [Mockito-Kotlin][42] A small library that provides helper functions to work with Mockito in Kotlin.
   * [Retrofit][43] A type-safe HTTP client for Android and Java.
   * [Gson][44] Gson is a Java library that can be used to convert Java Objects into their JSON representation.
   * [Glide][45] Glide is a fast and efficient open source media management and image loading framework for Android.

Great Resources for Learning
----------------------------
Thanks to all the documentation and great samples made by great programmers and Software Engineers.

![Android Jetpack](screenshots/jetpack.png "Android Jetpack Components")

Jetpack is a collection of Android software components to make it easier for you to develop great Android apps. These components help you follow best practices, free you from writing boilerplate code, and simplify complex tasks, so you can focus on the code you care about.

Jetpack comprises the androidx.* package libraries, unbundled from the platform APIs. This means that it offers backward compatibility and is updated more frequently than the Android platform, making sure you always have access to the latest and greatest versions of the Jetpack components.

Official Site [here][2]

#### Samples
 * [Sunflower][18] A Demo app uses many different Jetpack components to demonstrate Android development best practices.
 * [Samples for Android Architecture Components][19] A collection of samples using the Architecture Components with RxJava and Dagger 2.

Dagger 2
--------
Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.

Dagger aims to address many of the development and performance issues that have plagued reflection-based solutions.

Official Site [here][3]

#### Samples
* [todo‑mvp‑dagger][22]

ReactiveX
---------
![ReactiveX](screenshots/rx_logo.png "ReactiveX")

An API for asynchronous programming with observable streams

Official Site [here][5]

#### Samples
* [todo‑mvp‑rxjava][20] Uses RxJava 2 to implement concurrency, and abstract the data layer.
* [dev‑todo‑mvvm‑rxjava][21] Based on the todo-rxjava sample, this version incorporates the Model‑View‑ViewModel pattern.

Clean Architecture
------------------
![CleanArchitecture](screenshots/CleanArchitecture.jpg "Clean Architecture")

* [Clean Architecture: A Craftsman's Guide to Software Structure and Design Book][15] by Robert C. Martin (Uncle Bob)
* [The Clean Code Blog][6] by Robert C. Martin (Uncle Bob)
* [Android Architecture: Part 1 – Every New Beginning is Hard][7] by Tomislav Homan
* [Learn Clean Architecture for Android at Caster.io][55]

#### Samples
* [Android-CleanArchitecture][8] by Fernando Cejas
* [Android Clean Architecture Boilerplate][46]
* [Android Architecture Blueprints - MVP + Clean Architecture][47]

MVVM
----
* [Android Architecture Patterns Part 3: Model-View-ViewModel][54] by Florina Muntenescu 
* [Why to choose MVVM over MVP — Android Architecture][53]

#### Samples
* [todo‑mvvm‑databinding][23] Based on the todo-databinding sample, this version incorporates the Model‑View‑ViewModel pattern.
* [todo‑mvvm‑live][24] Uses ViewModels and LiveData from Architecture Components and the Data Binding library with an MVVM architecture.

Youtube Channels
----------------
* [Android Developers][48]
* [droidcon NYC][49]
* [Droidcon Italy][50]
* [droidcon SF][51]
* [droidcon Berlin][52]
* [Android Programming Dev tutorials][56]


[0]: https://developer.android.com/jetpack/foundation/
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/jetpack/
[3]: https://google.github.io/dagger/
[4]: https://developer.android.com/training/testing/
[5]: http://reactivex.io/
[6]: https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
[7]: https://five.agency/android-architecture-part-1-every-new-beginning-is-hard/
[8]: https://github.com/android10/Android-CleanArchitecture
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[15]: https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164/ref=sr_1_2?ie=UTF8&qid=1541340796&sr=8-2&keywords=clean+architecture
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[18]: https://github.com/googlesamples/android-sunflower
[19]: https://github.com/googlesamples/android-architecture-components
[20]: https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava/
[21]: https://github.com/googlesamples/android-architecture/tree/dev-todo-mvvm-rxjava/
[22]: https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/
[23]: https://github.com/googlesamples/android-architecture/tree/todo-mvvm-databinding/
[24]: https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live/
[25]: https://github.com/pabloaraya/movies-clean-architecture
[26]: http://www.omdbapi.com/
[36]: https://github.com/google/dagger
[38]: https://github.com/ReactiveX/RxKotlin
[39]: https://github.com/ReactiveX/RxAndroid
[40]: https://github.com/JakeWharton/timber
[41]: http://robolectric.org/
[42]: https://github.com/nhaarman/mockito-kotlin
[43]: https://square.github.io/retrofit/
[44]: https://github.com/google/gson
[45]: https://github.com/bumptech/glide
[46]: https://github.com/bufferapp/android-clean-architecture-boilerplate
[47]: https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/
[48]: https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg
[49]: https://www.youtube.com/channel/UCSLXy31j2Z0sdDeeAX5JpPw
[50]: https://www.youtube.com/channel/UC9f8652addezs8ZUuKPB4Ow
[51]: https://www.youtube.com/channel/UCKubKoe1CBw_-n_GXetEQbg
[52]: https://www.youtube.com/channel/UCF4O2pQ8vBV8YmSAWb5QRPw
[53]: https://android.jlelse.eu/why-to-choose-mvvm-over-mvp-android-architecture-33c0f2de5516
[54]: https://medium.com/upday-devs/android-architecture-patterns-part-3-model-view-viewmodel-e7eeee76b73b
[55]: https://medium.com/exploring-android/learn-clean-architecture-for-android-at-caster-io-8f1513621c30
[56]: https://www.youtube.com/channel/UCSwuCetC3YlO1Y7bqVW5GHg
