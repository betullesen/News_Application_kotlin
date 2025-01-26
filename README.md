# News Application 📰📱
------------------

This is a simple news application built with Kotlin for Android. It is an Android news app that provides users with the latest news. Firebase Authentication allows user login, and users can save their favorite news articles. Additionally, news can be searched using the search functionality, and saved favorite news articles can be listed. The app is developed using Android's modern architecture and aims to deliver the best user experience.


## Features 🚀

- **User Login:** User login is performed using Firebase Authentication. Users can log in with email and password.
- **Favorite News:** Users can add news to their favorites and view their favorite news. Favorite news can be deleted, and an "undo" operation can be performed.
- **News Search:** Users can search for news and find the stories they want. Search results are updated in real-time.
- **News List:** Current news is displayed in a list format. New news can be added to the list, and more news is loaded as the user scrolls the page.
- **Error Management:** Error messages are shown during search or news loading operations.

## Technologies Used 🔧

- **[Kotlin](https://kotlinlang.org/)**: The primary language used for Android app development.
  
- **[Firebase](https://firebase.google.com/)**: Used for user authentication processes, enabling users to log in securely to access features such as saving news articles.
- **[ViewBinding](https://developer.android.com/topic/libraries/view-binding)**: A method to bind UI components, providing safer and more efficient code by reducing the need for `findViewById` calls.
- **[Fragment](https://developer.android.com/guide/fragments)**: Used to create reusable UI components, making the app's interface modular and efficient across different screens.
- **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata)**: Used to observe and update UI data changes in a lifecycle-aware manner, ensuring the UI is updated with the most current information.
- **[Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)**: Used to manage the lifecycle of the app and ensure a sustainable connection between the UI and data, preventing memory leaks.
- **[Navigation Component](https://developer.android.com/guide/navigation)**: Used to manage screen transitions and navigation within the app, simplifying back-stack management.
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: Used for managing and sharing UI data, providing lifecycle-compatible data to keep the UI updated even through configuration changes.
- **[RecyclerView](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView)**: Used to display news articles in a list format, with support for efficient data handling and UI updates.
- **[Room Database](https://developer.android.com/topic/libraries/architecture/room)**: Ensures that favorite news are stored locally on the device, allowing for offline access to saved news.
- **[Retrofit](https://square.github.io/retrofit/)**: Used to make network requests and fetch news data from an API, handling the process in a clean, efficient, and type-safe manner.
- **[Glide](https://github.com/bumptech/glide)**: Ensures that news images (such as thumbnails) are loaded quickly and efficiently into ImageViews, providing smooth UI interactions.
- **[Coroutines](https://developer.android.com/kotlin/coroutines)**: Used to manage asynchronous tasks, allowing data fetching in the background without blocking the UI and providing a responsive experience for users.


## Preview 🎞
----------
![Image](https://github.com/user-attachments/assets/0fabe85f-f698-44ed-b2dd-0e982baeec7c)



## Screenshots 📸
----------------

| Splash Screen | Login Screen | News Headlines |
|----------------|--------------|----------------|
| ![Splash Screen](https://github.com/user-attachments/assets/38853cbc-dc24-4ced-8c9d-5dff6e7f00ba) | ![Login Screen](https://github.com/user-attachments/assets/0469f691-6244-46a7-a0fe-8f767c919697) | ![News Headlines](https://github.com/user-attachments/assets/b8960663-2f08-440f-a0d4-19add6cd1aa4) |

| News Detail | Favorite News | Additional Image |
|-------------|---------------|------------------|
| ![News Detail](https://github.com/user-attachments/assets/b7b25a24-d278-4409-9bb0-7a0ff6a76bf0) | ![Favorite News](https://github.com/user-attachments/assets/8f718e4b-af8c-48ad-b59d-62981433b005) | ![Additional Image](https://github.com/user-attachments/assets/90489b38-27d9-42ff-ac84-a42537029624) |



