# Numeral system conversion api

## Introduction

The numeral system conversion API provides a service in which numbers can be converted between different [numeral systems](https://en.wikipedia.org/wiki/List_of_numeral_systems).

The current implementation allows for conversions between the roman and decimal number systems.

## Setting up the project

Clone the repository to your own computer. Make sure you have Java 8 installed. 

To build the project, do

    ./gradlew build
    
to run the project, do

    ./gradlew bootrun
    
    
Gradle tasks can be excluded by placing an `-x` in front, e.g.

    ./gradlew build -x test

   
All runnable tasks can be listed with `gradle tasks`.

Built with [Spring Boot](https://github.com/spring-projects/spring-boot)

Once the service is running, the conversion endpoint is at `api/conversion`


## API documentation

The API is documented with Open API (aka Swagger) and can be read at http://localhost:8080/swagger-ui.html

Documentation on how to build Open API in Swagger [here](http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

[Open API specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.1.md) as [implemented in Java](http://docs.swagger.io/swagger-core/v1.3.12/apidocs/index.html?com/wordnik/swagger/annotations/ApiModelProperty.html) 


## Running the tests

The `test` and `check` tasks will run the tests:
```
./gradlew test
```

or

```
./gradlew check
```


## Docker

The project can create a Docker container.

Just run:

```
./gradlew startContainer
```

And it will create a docker image named `boot-react/boot-react`.

```
> docker images
REPOSITORY                                TAG                 IMAGE ID            CREATED             SIZE
numeral                                   latest              1ed12e3fbc0f        23 seconds ago      768MB


```
