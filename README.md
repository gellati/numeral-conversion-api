# Numeral system conversion api

## Introduction

The numeral system conversion API provides a service in which numbers can be converted between different [numeral systems](https://en.wikipedia.org/wiki/List_of_numeral_systems).

The current implementation allows for conversions between the roman and decimal number systems.

## Setting up the project

Clone the repository to your own computer. Make sure you have Java 8 installed. 

### Building

Gradle is used as the project's build tool. To build the project, do

    ./gradlew clean build

This creates a runnable .jar file under build/libs.

### Running the application
    
The server can be started by going to the jar containing directory and entering the following command

    java -jar numeral-conversion-service-0.1.0-SNAPSHOT.jar
    
A simpler way to start the server is to do

    ./gradlew bootrun
    
in the project root directory. 

This will start a local server at `http://localhost:8080`
    
Gradle tasks can be excluded by placing an `-x` in front, e.g.

    ./gradlew build -x test

   
All runnable Gradle tasks can be listed with `gradle tasks`.


### Usage

Once the service is up and running, the conversion endpoint is at `/api/conversion`. Here numeral conversion can be done with GET and POST requests.

The request is done with the following parameters

|Parameter        | Type         | Description |
|-----------------|--------------|-------------|
|number           | String       | the number to convert |
|source           | String       | source numeral system from which to convert |
|target           | String       | target numeral system to which convert |


A GET request can be done with `curl`

    curl -X GET 'http://localhost:8080/api/conversion?source=decimal&target=roman&number=6' 

If the request succeeds, the server will return an answer in JSON format and 200 OK in the header. 

Example output:

    {
    "sourceNumeralSystem": "decimal",
    "sourceNumber": "6",
    "targetNumeralSystem": "roman",
    "targetNumber": "VI"
    }

A POST request can be made to the same url, giving a response with the same information.
The POST request should have `Content-Type: application/json` and the request parameters in the body.

Example of a POST request body:

    {"source":"decimal","number":"6","target":"roman"}


The return message contains the following information

|Parameter           | Type         | Description |
|--------------------|--------------|-------------|
|sourceNumber        | String       | the converted number |
|sourceNumeralSystem | String       | source numeral system from which converted |
|targetNumeralSystem | String       | target numeral system to which converted |
|targetNumber        | String       | the result number of the conversion |



Currently supported source and target numeral systems are decimal and roman.



## Documentation

### Java code documentation

The Java code is documented with [JavaDoc](http://www.oracle.com/technetwork/java/javase/documentation/javadoc-137458.html). The documentation can be generated with the following command:

    javadoc -d ./docs -sourcepath ./src/main/java/ -subpackages org

This creates the documentation files in the `docs` folder which can be read with a web browser.


### API documentation

The API is documented with Open API (aka Swagger) and can be read at `http://localhost:8080/swagger-ui.html`

Documentation on how to build Open API in Swagger [here](http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api).

Using instructions on how to implement the [Open API specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.1.md)  from [here](http://docs.swagger.io/swagger-core/v1.3.12/apidocs/index.html?com/wordnik/swagger/annotations/ApiModelProperty.html).



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

The image can be run with

    docker run numeral

Once the container is up and running, the service is accessible at `http://localhost:8080`.


# Tech and license stack

Built with [Spring Boot](https://github.com/spring-projects/spring-boot) and [Gradle](https://gradle.org/), API documentation with [Open API]() and dockerisation with the [gradle docker plugin](https://github.com/bmuschko/gradle-docker-plugin).

The following table lists used technologies and libraries together with their associated license.

|Library      |                                                       License |
|--------------------------------------------------------------------|----------|
|[Spring Boot](https://github.com/spring-projects/spring-boot)        |Apache License 2.0 |
|[Gradle](https://gradle.org/)                                        |Apache License 2.0 |
|[Open API](https://www.openapis.org/)                                 | Apache License 2.0 |
|[Docker CE](https://www.docker.com/community-edition)                 |Apache License 2.0|
|[gradle docker plugin](https://github.com/bmuschko/gradle-docker-plugin) | Apache License 2.0 |
|[Guava](https://github.com/google/guava)                           | Apache License 2.0 |
|[Springfox](https://github.com/springfox/springfox)                  | Apache License 2.0 |
|[Apache Commons Lang](http://commons.apache.org/proper/commons-lang/)| Apache License 2.0 |
