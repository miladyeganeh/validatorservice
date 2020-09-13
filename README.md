# Currency Rate Service

Java REST application for the currency rate analyzing.

## Prerequisites and Solution

- [x] Code: Java 8, Spring Boot, Spring Web Framework, Maven
- [x] Tests: Junit, Spring Mock MVC
- [x] Algorithm used to calculate the Trends and average

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. 

One way is to execute the `main` method in the `com.company.validator.ValidatorService` class from your IDE.

Alternatively you can use the Docker. For deploying write below command line in application directory
```shell
docker-compose up --build --force-recreate --no-deps [-d] [<service_name>..]
```
## Documentation
f you want to access the api you can visit documentation on http://localhost:8080/swagger-ui.html#/

http://localhost:8080/swagger-ui.html#/

#### Requests examples ready to play with on localhost

- http://localhost:8080/api/v1/requests   ->   requestBody: {"customerID":1,"tagID":2,"userID":"aaaaaaaa-bbbb-cccc-1111-222222222222","remoteIP":"123.234.56.78","timestamp":1500000000}
- http://localhost:8080/api/v1/requests/customers/{customerID}
- http://localhost:8080/api/v1/requests/times/{timeStamp}
