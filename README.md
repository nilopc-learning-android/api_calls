## TODO

- Implement Repository Drivers
- Inject Api to Repository

----

# api_calls

## Retrofit

- To generate POJOs: http://www.jsonschema2pojo.org/

**Missing Caching when user goes offline**
- http://stackoverflow.com/questions/23429046/can-retrofit-with-okhttp-use-cache-data-when-offline
- https://github.com/digitalbuddha/StoreDemo

## Dagger 2

- https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2
- http://www.vogella.com/tutorials/Dagger/article.html
  - Meter la entrada en un archivo Module... y de ahí venirse arriba haciendo: 
    - main/
      - domain/
      - repository/
      - view/
      - MainModule.java
    - usersearch
      - domain/
      - repository/
      - view/
      - UserSearchModule.java
    - user
      - domain/
      - repository/
      - view/
      - UserModule.java


Dagger2, how it works: 

- Create a @Module that contains methods tagged with @Provides in it.     
- Use @Provides to create a method that returns the object.
- Use @Inject in the place where you want to use this. This requires:
    - Creating an public interface xxComponent that contains all the places where you will @Inject this object.

```java
//MyAppComponent.java

@Singleton
@Component(
    modules = {
        MyAppModule.class, //1) THIS IS LINKED WITH 2
        DataModule.class,
        NetworkModule.class
    }
)
public interface MyAppComponent{
    void inject(MyApp myApp);
}
```


```java
//MyAppModule.java

@Module
public class MyAppModule{
    private final MyApp app;
    
    public MyAppModule(MyApp app) {
        this.app = app;
    }
    
    @Provides
    MyApp provideMyApp() {
        return app;
    }
}
```

```java
public class MyApp extends Application
{
    private MyComponent component;
    
    @Override public void onCreate {
        component = DaggerMyAppComponent
            .builder()
            .myAppModule(new MyAppModule(this))  //2) THIS IS LINKED WITH 1
            .dataModule(new DataModule(this))
            .networkModule(new NetworkModule(this))
            .build();
    }
    
    /**
     * This method provides access to all the dependencies.
     */
    public MyComponent getComponent()
    {
        //...
    }
}
```

---


```java
@Module
public class NetworkModule
{
    @Provides
    @Singleton
    Retrofit provideUserApi(@Named("userApiUrl") string baseUrl) {
        return ...
    }
    
    @Provides
    String providesUserApiUrl() {
        return "https://google.com";
    }
}
```
