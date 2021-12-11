# Retail Book Application 

Online book retail application to deliver items from its one centralized warehouse to their
customers within the same day.

###Requirements
Java (min SDK 11)   
MongoDb   
Docker

To run on local host VM arguments; -Dspring.profiles.active=local

###Docker
> docker build . -t getir/retail-book
> docker run -p 8080:8080 getir/retail-book

Also you need running mongodb in docker.
Getting docker image with this command:
> docker pull mongo

More information: https://hub.docker.com/_/mongo?tab=description

###Swagger
Swagger url: http://localhost:8080/swagger-ui/#/


###Postman
 Postman Collection can be found under this directory:
    /postman/Getir.postman_collection.json
    
###MongoDb
To run application you need a running mongodb. (Also to be able to run tests.)
<p>Run with this command.

> systemctl start mongod


#Retail Book

The application consist of five main parts.

### 1.Authentication
To authenticate send authRequest to this url `localhost:8080/api/authentication/authenticate` with this json request.
<p>
{ "username": _username_, "password": _password_ } 
Note: You can find this request in postman collection.

This service returns jwt token to be able to request other apis. Jwt token should be added to authorization header of requests in postman collection.

Note: To make it simple dummy user repository is used.It has username,password values in DummyUserRepository class.
To create authenticated user you can add in this map.

###2.Customer
* Persist new customers
* Query all orders of the customer


###3.Book
* Persist new items
* Update items quantity

###4.Order
* Persist new orders
* Query order by id and time interval

###5.Statistics 
* Serve customer monthly statistics



