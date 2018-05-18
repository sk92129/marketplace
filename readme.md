

To build:

mvn clean install


To run:

mvn spring-boot:run


Import the postman collection 

* Run: GET all projects 
To see an empty response -- since there should be no projects yet
* Run: POST add project 
add a couple of project with different date and maximum budget
* Run: POST add bid with the project ID
Specify bid below or above the max bid, and before or after the date deadline
* Run: GET single project with the project ID
It will return the project and the winning lowest bid within the max budget and within the last date time.

The SELLER and BUYER role and account was not implemented -- but I have an sample implementation that I could integrate into this project but it would take a bit more time.  

This is the SpringBoot 2.x project which uses the roles and protection to the endpoints.
https://github.com/callicoder/spring-security-react-ant-design-polls-app


