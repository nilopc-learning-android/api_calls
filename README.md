# api_calls

## Retrofit

- To generate POJOs: http://www.jsonschema2pojo.org/

**Missing Caching when user goes offline**
- http://stackoverflow.com/questions/23429046/can-retrofit-with-okhttp-use-cache-data-when-offline
- https://github.com/digitalbuddha/StoreDemo

## Dagger 2

- https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2
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
