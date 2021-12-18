# Retail Book Application 

Online book retail application to deliver items from its one centralized warehouse to their
customers within the same day.

### Requirements
Java (min SDK 11)   
MongoDb   
Docker


### Docker
Firstly, running mongodb is required to build docker image of application for tests.

> docker build . -t getir/retail-book

> docker-compose -f docker-compose.yaml up -d

To start:
> docker-compose start 

To stop:    
> docker-compose stop 

To remove:
> docker-compose down -v  


### Swagger
Swagger url: http://localhost:8080/swagger-ui/#/


### Postman
 Postman Collection can be found under this directory:
    /postman/Getir_retail-book.postman_collection.json
    
### MongoDb
To run application you need a running mongodb. (Also to be able to run tests.)
<p>Run with this command.

> systemctl start mongod


# Retail Book

The application consist of five main parts.

### 1.Authentication
To authenticate send authRequest to this url `localhost:8080/api/authentication/authenticate` with this json request.
<p>
{ "username": _username_, "password": _password_ } 
Note: You can find this request in postman collection.

This service returns jwt token to be able to request other apis. Jwt token should be added to authorization header of requests in postman collection.

Note: To make it simple dummy user repository is used.It has username,password values in DummyUserRepository class.
To create authenticated user you can add in this map.

### 2.Customer
* Persist new customers
* Query all orders of the customer


### 3.Book
* Persist new items
* Update items quantity

### 4.Order
* Persist new orders
* Query order by id and time interval

### 5.Statistics 
* Serve customer monthly statistics



