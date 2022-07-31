 CREATE DATABASE USER_DETAILS;
 USE USER_DETAILS;
 CREATE TABLE USER_PROFILE_INFO (username  varchar(30) PRIMARY KEY,id int,firstName varchar(30),lastName varchar(30),annualSalary int DEFAULT 12000,dateOfBirth DATE, email varchar(30),gender varchar(10), phone varchar(10),userStatus int,password varchar(30));
 

 CREATE TABLE USER_ADDRESS(addrName varchar(30) ,username varchar(30) ,addrLn1 varchar(50),city varchar(30),stateCode varchar(10),postalCode varchar(10),country varchar(10),PRIMARY KEY(addrName,username),FOREIGN KEY (username) REFERENCES USER_PROFILE_INFO(username));

DROP TABLE USER_ADDRESS;
DROP TABLE USER_PROFILE_INFO;

SELECT * FROM USER_PROFILE_INFO;
SELECT * FROM USER_ADDRESS ;
