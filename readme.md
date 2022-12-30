## doctor-patient-rest-service
Production ready maven based Spring Boot starter application with example cases of handling Doctor and Patient Scenario with Spring.

## Description
Starter kit for booting up the development of a API oriented and transaction based spring Java server.Since JPA is used, developers are free to opt for any SQL based DB engine for persistence. The preferred IDE for development is IntelliJ which comes with a plethora of useful JAVA tools to support Spring Boot development, but developers are free to opt for Eclipse or STS as well. The focus in this project is solely upon the SpringBoot development with business cases involving transactions and writting proper unit and integration tests for them.

## Technology

- **Spring Boot**     - Server side framework
- **JPA**             - Entity framework
- **Lombok**          - Provides automated getter/setters
- **Actuator**        - Application insights on the fly
- **Spring Security** - Spring's security layer
- **Authentication**  - Basic Authentication
- **Swagger**         - In-built swagger2 documentation support
- **Docker**          - Docker containers
- **Junit**           - Unit testing framework
- **Mysql**           - Mysql database embedded version

## Application Structure


## Build Project With Unit test cases
There are multiple unit test cases written to cover the different components of the application.

````
mvn clean install
````

## Running the server locally
The doctor-patient-rest-service application can be started using your favourite IDE and its run configuration support. If you are a terminal savvy, please use the following command -

````
mvn spring-boot:run
````

## Docker
doctor-patient-rest-service supports docker container out of the box. This boilerplate is meant to cater to both web based applications as well as scalable micro services written in Java. Please select one of the following two ways to use docker to build and run the application -

**Dockerfile**

To build a fresh image, use -
````
docker build -t doctor-patient-rest-service .
````
To run the new image, use -
````
docker run -P -it --rm -p 9191:9191 --env DB_URL=jdbc:mysql://host.docker.internal:3306/doctorDB?createDatabaseIfNotExist=true --env DB_USERNAME=root  --env DB_PASSWORD=root -m 256mm --cpus=1 -d --name doctor-patient-rest-service doctor-patient-rest-service:latest
````

**Docker-Compose**

To build a fresh image, use -
````
docker-compose build
````
To run the new image, use -
````
docker-compose up
````

## Swagger Documentation
Swagger documentation is in-built in this starter-kit and can be accessed at the following URL -
````
http://<host-name>:9191/swagger-ui.html (Ex:- http://localhost:9191/swagger-ui.html#/)
````


## Note

- **Run Without Docker**  - Please make sure update 'application.yml' file For DB connection and API Authentication User Name and Password
- **Run With Docker**     - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command

## API End Point

- **listAllDoctors**
````
**Method :** GET
**URL :** http://localhost:9191/v1/api/doctors/list
**Header :** Authorization : Basic VGVzdFVzZXI6dGVzdDEyMw==

**Case 1 :- Valid Request**
    [
        {
            "id": 1,
            "name": "Dr. Trivadi",
            "email": "test@gmail.com",
            "degree": "MBBS",
            "specialization": "Heart Specialist"
        }
    ]

Case 2:-  InValid Request with Authorization Missing in Header
    {
        "timestamp": "2022-12-30T08:06:05.844+00:00",
        "status": 401,
        "error": "Unauthorized",
        "path": "/v1/api/doctors/list"
    }

````

- **getDoctorById**          - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command
- **saveDoctor**             - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command
- **addPatientUnderDoctor**  - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command
- **updateDoctorNameById**   - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command
- **dischargePatient**       - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command
- **dischargePatient**       - In case if you use local database then only we have to provide host like 'host.docker.internal' in place of localhost in Docker run command




## Contributors
[Pavan Patel](https://www.linkedin.com/in/pavan-patel-991a5a38/)
