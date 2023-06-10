# About project

This project was created to complete the tech task that was received as a part of the job application.

This project demonstrates how Spring with the Spring Boot can be used to create a REST API
that will receive a ticker cart containing passengers and its luggage bags and will return same
object but with calculated prices for the tickets.

## Requirements

For building and running the application you need:

- [JDK 17 or higher](https://adoptium.net/)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute
the `main` method in the `com.buscompany.ticketprice.TicketpriceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
