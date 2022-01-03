# EkarAssignment
Ekar Assignment for Mobile Engineers

## UI
App consist of 3 different fragments and 1 root activity. Activity holds a container layout in order to manage fragments which will be controlled by navigation component.

Fragments :
* SplashScreen
* MapScreen
* VehicleScreen

## Screenshots

<p align="center">
<img src="https://user-images.githubusercontent.com/13941871/147888181-8e279fa3-6971-494f-8fa4-130a3d7dd292.jpg" width="30%" />  
<img src="https://user-images.githubusercontent.com/13941871/147887838-8ceb6264-07fd-479a-8969-ceb0aca27873.jpg" width="30%" />  
<img src="https://user-images.githubusercontent.com/13941871/147887798-9bbd3d2d-737e-4bcb-b786-c80f90e86f15.jpg" width="30%" />  
</p>

## App Flow
#### SplashScreen
App opens with splash screen fragment and navigate to the map screen after showing the ekar logo to the user for 2 seconds.

#### MapScreen
Map Screen is the main part of the app. In first launch, random markers are placed on the map around Dubai zone. Features is listed below:
* Different colored markers placed in map.
* Click marker to navigate vehicle screen.

#### VehicleScreen
This screen responsible for showing all details of vehicle such as price, standard seating, booking fee and the other things.

## Architecture
This app adopts Clean Architecture behaviour. Here is the package structure:

#### Core
It is the package that contains all the common and base classes used within the application. 
Extensions, deciders, utils and base classes are included in this package.

#### Data
Data package should include response models, data source and api methods. It shouldn't know any logic.

#### UI 
Ui like a feature. It contains Fragments, view models and feature related classes like a domains, mappers and ui models.
Make sure that all classes here are specific to the this feature. If it is a class that is also used in other features, it should be moved to the common package.

#### Di
This package may actually be inside the common module. But I prefer to carry outside of core package to be more visible. 

#### Ui-Component
In large projects, we need to use a view component in more than one place. So i moved common view components under ui-component package.

## Tech Stack
* [Kotlin](https://kotlinlang.org/) , [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) , [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
* [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency Injection
* [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google suggested app architecture
* [Retrofit2 & OkHttp3](https://github.com/square/retrofit)
* [Gson](https://github.com/google/gson)
* [Navigation Component](https://developer.android.com/guide/navigation) - Single activity multiple fragments approach


## TODOs and Improvements
- UI test.
- Better Design
- Unit tests for different screnios
- Implementation of static code analysis tool(ktlint or detekt)
- Styling definitions for textviews and buttons etc.
