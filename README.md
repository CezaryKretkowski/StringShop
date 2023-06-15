# StringShop
String shop backend application in java spring boot

## Description
The aim of the project was to create a server side application that would allow get and store information about product and users of ecomerce application . The application was written using the Spring boot framework. 

## Frontend Application
The client side of the application will be available at ...

## Installation 
Java version 20 and Mavane is required to run the application.
Mysql database is also required.


Project download:
1. Clone a Git repository with the command: git clone https://github.com/CezaryKretkowski/StringShop.git
2. You can also download the project as a ZIP archive from the project's GitHub page.
3. Open  StringShop-master folder in terminal.
4. In application.properties define url, username and password to your database. 
Default is  
```
  spring.datasource.url = jdbc:mysql://localhost:3306/stringshop
  spring.datasource.username=root
  spring.datasource.password=
```
6. Run command.
```cmd
   mvn clean install
```
5. Next go to target
```cmd
   cd target
```
6. Run application.
```cmd
  java -jar StringShop-0.0.1-SNAPSHOT.jar 
```
