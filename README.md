# Customer Service Management System (CSMS)

## Description
Customer Service Management System (CSMS) is a Spring Boot-based application designed to manage end to end details about the customers. It supports key operations such as creating, updating, fetching and soft-deleting information on various tables. The details stored are corresponding to customers that get their car serviced under our application.

## Features
### Tables
* Customers
* Vehicles
* Services
* Appointments
* Employees
* Invoices
* Users (customers and employees who have logged in to our system)

### CRUD operations 
Crud operations are implemented on each table. When a delete operation is done, the row is marked inactive and the data is retained, thus implementing soft delete feature.

## Technologies Used
* Backend - Java, Spring Boot, JPA/Hibernate
* Database - MySQL
* Tools: Maven, Postman (for API testing)
* Version control - Git, Github
* Build Tool - Maven

## Setup
* Clone the repository
* Configure the MySQL database
* Update the application.properties file with your MySQL database credentials
* Install dependencies
* Run the application

