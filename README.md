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

@Component(
    modules = {
        MyAppModule.class //This component works will Module to build the class I need.
    }
)
public interface MyAppComponent{
    void inject(MyActivity myActivity);
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
