# Retail Book Application 

Online books retail application to deliver books from its one centralized warehouse to their
customers within the same day.

###Requirements
Java (min SDK 11)   
MongoDb   
Docker


The application consist of five main parts.

### 1.Authentication
To authenticate send authRequest to this url `localhost:8080/api/authentication/authenticate` with this json request.
<p>
{ "username": _username_, "password": _password_ } 
Note: You can find this request in postman collection.

This service returns jwt token to be able to request other apis.

Note: To make it simple dummy user repository is used.It has username,password values in DummyUserRepository class.
To create authenticated user you can add in this map.

###2.Customer
* Persist new customers
* Query all orders of the customer


###3.Book
* Persist new books
* Update books stock

###4.Order
* Persist new orders
* Query order by parameters

###5.Statistics 
* Serve customer monthly statistics



