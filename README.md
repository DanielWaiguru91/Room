# Room-Database
An app implementing CRUD operations in Room database library using kotlin

### Room
Room is a library by google that provide an abstraction layer over SQLite Database that allows fluent data access harnessing the full power of SQLite
For more information read [Android Documentation](https://developer.android.com/training/data-storage/room)

#### To use Room database in your app you need to;
* Add Room dependencies in your app's build.hradle file
```
    //Room Database
    def room_version = "2.2.5"

    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    // For Kotlin use kapt instead of annotationProcessor

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"

    

    // Test helpers
    testImplementation "androidx.room:room-testing:$room_version"
    
```
   
add kapt kotlin anotation processor plugin

```apply plugin: 'kotlin-kapt'```


