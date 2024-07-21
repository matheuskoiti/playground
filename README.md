# Mk playground

This Android app is a simple project designed for educational purposes. 
It demonstrates fundamental concepts of Android development, including user interface design, 
data handling, and basic functionality.

## Architecture

This Android project follows the MVVM (Model-View-ViewModel) architecture pattern, incorporating 
the state management concepts from MVI (Model-View-Intent)

## Packages

1. app: The main package that serves as the entry point of the application
2. arch: Contains the base viewModel, state and action implementation, providing a foundation for the MVVM with MVI approach
3. network: Houses API services interfaces and retrofit instance
4. features: Contains individual modules for each feature of the application

## Libs

1. Kotlin
2. Koin
3. Coroutines
4. Retrofit

## Functionality

This Android app displays a list of popular movies by fetching data from a public API provided by The Movie Database (TMDB)



