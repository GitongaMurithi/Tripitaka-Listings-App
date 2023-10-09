## Tripitaka-Listings-App
The Tripitaka Listing App is an android application that allows users to view all the listed properties. Users can therefore book the property they are interested in among other activities.

### Features
#### 1. Google sign in integration
For the users to be able to use the app, they are required to sign in with google. This ensures ultimate security

![]()

#### 2. List of listings
All listings are displayed to the user as a list. Users can scroll down the list of properties looking for the one interests them. 
Each property has some information such as price,guest and number of bedrooms available displayed

#### 3. Listing Details
Upon clicking on a particular listing/property the user is able to view more details about that property. The information displayed include the booked dates,ratings and so on

#### 4. Map Integration
The app should allow users to view property location in maps. Unfortunately,the app currently is not able to display the maps due to lack of Google play api key. Google requires that I should provide a valid 
payment method to access the key.
The process of getting a valid payment method went beyond the project deadline. Sorry for that, looking forward to implementing the feature in future

#### 5. Calendar Display
The app displays a calendar component that visually highlights and disables booked dates for each listing

#### 6. Location search
Users are able to search for a particular property based on ots location

### How is the app built?
* [Kotlin](https://kotlinlang.org/) - The app is built using Kotlin programming language for the backend
* [XML](https://developer.android.com/codelabs/basic-android-kotlin-training-xml-layouts#:~:text=XML%20stands%20for%20eXtensible%20Markup,UI%20layout%20of%20Android%20apps.) - The layout of the application is implemented in XML
* [Gson](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - The app ues a combination of local json parsing through the assets folder and [MVVM](https://developer.android.com/topic/architecture) to fetch data from the local json file
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - The app uses the backend processing of tasks especially when signing in the user. This is achieved through coroutines

#### This is a subject to improvement
