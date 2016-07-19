GUAU:
- https://github.com/nilopc-learning-android/android-examples
- http://hannesdorfmann.com/android/evolution-of-the-repository-pattern

THIS IS HUGE:
- https://github.com/nisrulz/android-utils/tree/9158112f92c451d5c72e1c4c4ce87477000f1910/TestProjectForScripts/scripts/src/main/java/github/nisrulz/scripts

CUSTOM VIEWS: 
- https://corner.squareup.com/2014/10/advocating-against-android-fragments.html
- https://developer.android.com/training/material/lists-cards.html



# Todo:

- Load from web deeplink (how do these even work?!)

### Retrofit factory

### Permissions on demand
- https://github.com/Karumi/Dexter


### Network status

- Do not call api is no internet and not un cache
- https://github.com/nilopc-learning-android/ZhiHuDaily/blob/master/app/src/main/java/com/marktony/zhihudaily/Utils/NetworkState.java

### Social login

- https://github.com/FuckBoilerplate/RxSocialConnect-Android/blob/master/app/src/main/java/org/fuckboilerplate/rxsocialconnect/connections/ConnectionsFragment.java

### API Calls cache with RxCache

- https://github.com/VictorAlbertos/RxCacheSamples/blob/master/sample_data/src/main/java/sample_data/Repository.java

### Realm for local storage database.

- https://github.com/realm/realm-java/tree/master/examples/rxJavaExample
- https://github.com/realm/realm-java/blob/master/examples/rxJavaExample/src/main/java/io/realm/examples/rxjava/gotchas/GotchasActivity.java


### Glide para cargar imagenes

- https://github.com/bumptech/glide

### Picaso para cacheo de imagenes
Images add much-needed context and visual flair to Android applications. Picasso allows for hassle-free image loading in your application—often in one line of code!

### Dialogs

https://github.com/afollestad/material-dialogs

---


**Testing**

- https://github.com/facebook/screenshot-tests-for-android
- https://github.com/mattlogan/locationtracker (*unit style)

**Repository cache: caching when user goes offline**

- http://stackoverflow.com/questions/23429046/can-retrofit-with-okhttp-use-cache-data-when-offline
- https://github.com/digitalbuddha/StoreDemo

**Retrofit to Domain Entities**

- https://github.com/android10/Android-CleanArchitecture/blob/master/data/src/main/java/com/fernandocejas/android10/sample/data/repository/UserDataRepository.java

**Cache**

- https://github.com/android10/Android-CleanArchitecture/blob/master/data/src/main/java/com/fernandocejas/android10/sample/data/cache/UserCache.java
- https://github.com/android10/Android-CleanArchitecture/blob/master/data/src/main/java/com/fernandocejas/android10/sample/data/cache/UserCacheImpl.java

---

# Done:

- Stop weird refreshing. Remove progressbar status right having UI elements populated.

### UseCases

- https://github.com/android10/Android-CleanArchitecture/blob/master/domain/src/main/java/com/fernandocejas/android10/sample/domain/interactor/UseCase.java
- UseCase with RxJava

### RxJava and RxAndroid

- Drop AsyncTask por Rx
- https://github.com/nilopc-learning-android/EffectiveAndroidUI 
- http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/
- http://akarnokd.blogspot.com.es/

### Retrofit

- Easy API endpoint data access.
- To generate POJOs: http://www.jsonschema2pojo.org/
- Observables

### Add DependencyInjecion

- Added Dagger2 for non UI related
- Added ButterKnife for UI related: https://github.com/JakeWharton/butterknife


### Working with views

 - Activity or Fragment
     - Recibe: Presenter
     - setea/esconde/muestra Fragments
     
 - Presenter:
    - Recibe: UseCase
    - Recibe: UserModelDataMapper
    - Internamente implementa:
        - private final class xxxSubscriber extends Rx.Subscriber


### PageAdapter vs FragmentPagerAdapter vs FragmentStatePagerAdapter

 - `FragmentPagerAdapter`
    - Fragments are detached, NOT destroyed.
    - Useful for SMALL list of fragments. 
    - Remains in memory. **Fills up memory and app will crash** if lots of fragments.
    - Use for static data not coming from network and does not require calculations.
 - `FragmentStatePagerAdapter`
    - Works well for LARGE lists. 
    - It destroys fragments when not used.
    - Not kept in memory (as it keeps destroying).
    - Requires proper use of CACHING (eg: repos) when using data from network or heavy calculations.
 - `PageAdapter` 
    - Items are destroyed. 
    - Useful for SMALL lists.
