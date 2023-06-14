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

## How to use

After running the application it has one HTTP POST endpoint available at `/bus/ticket/calculate`
It awaits a JSON formatted bus ticket cart object as a request body. The answer will contain the same request object,
but with calculated prices for each passenger and luggage bag.

Request example:

```json
{
	"busTerminalNameFrom": "test",
	"busTerminalNameTo": "test2",
	"passengers": [
		{
			"name": "name1",
			"surname": "surname1",
			"birthDate": "2000-06-08",
			"luggage": [
				{
					"weight": 20,
					"height": 10,
					"width": 10,
					"length": 50
				},
				{
					"weight": 20,
					"height": 10,
					"width": 10,
					"length": 54
				}
			]
		},
		{
			"name": "name2",
			"surname": "surname2",
			"birthDate": "2007-06-08",
			"luggage": [
				{
					"weight": 20,
					"height": 10,
					"width": 10,
					"length": 54
				}
			]
		}
	]
}
```

Response example:

```json
{
	"busTerminalNameFrom": "test",
	"busTerminalNameTo": "test2",
	"passengers": [
		{
			"name": "name2",
			"surname": "surname2",
			"birthDate": "2007-06-08",
			"luggage": [
				{
					"height": 10,
					"width": 10,
					"length": 54,
					"weight": 20.0,
					"price": 3.63
				}
			],
			"ticketPrice": 6.05,
			"child": true
		},
		{
			"name": "name1",
			"surname": "surname1",
			"birthDate": "2000-06-08",
			"luggage": [
				{
					"height": 10,
					"width": 10,
					"length": 50,
					"weight": 20.0,
					"price": 3.63
				},
				{
					"height": 10,
					"width": 10,
					"length": 54,
					"weight": 20.0,
					"price": 3.63
				}
			],
			"ticketPrice": 12.10,
			"child": false
		}
	],
	"totalPrice": 29.04
}
```
