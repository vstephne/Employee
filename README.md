# Employee
The repo contains spring boot application to access employee records for organization
DOCUMENTATION

Github link: https://github.com/vstephne/Employee
POSTMan API link:  https://www.getpostman.com/collections/8008e8b6b112a47a2556

ASSUMPTION:
1.	Assuming username for every user is unique for a user
2.	Assuming minimum annualSalary is 12000$ and set it as default in case not entered
3.	A user can have different address but their names must be unique for a given user

SYSTEM DESIGN:

1.	DATABASE
a.	The database name is USER_DETAILS
b.	The Database has two tables 
i.	USER_PROFILE_INFO which contains all the information about Users
ii.	The data also includes username and password this could be put into a separate table as  they are for a specific purpose login and logout but as they are singular for a given user at a given time I have added to same USER_PROFILE_INFO table
iii.	The next table is USER_ADDRESS it has addresses of users as a user can have multiple addresses but their names must be unique.
iv.	The combination of both username and addrname is made a primary key.
2.	SPRING BOOT APPLICATION:
a.	I have divided the code into multiple sections
i.	Entity: This package mainly has information about the table the columns their type and their getter-setter methods.
ii.	Dao:  This is the data layer. It has functions that fetch data or perform any SQL related function.
iii.	 Service: It is one layer above dao layer here we call the functions in Dao layer and if there are any extra functionalities we add it here
iv.	Controller: It is the entry point for any API the mappings of different API to their respective functions are done at  this layer.
 
This is POSTMAN Collection with all the API: https://www.getpostman.com/collections/8008e8b6b112a47a2556

STEPS to run the application:
1.	Install MYSQL in the system 
2.	Open the .sql file attached in email or found on repository under SQL folder
3.	Clone the repository
4.	Run it as a springboot application
5.	Run various API dfound on post man which can be accessed by above link


