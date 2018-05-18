

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


Exercise Difficulty Level: Moderate 
   Due to the complexity of using roles of SELLER and BUYER and to properly protect the endpoint with springboot 2.x, it requires a bit more set up.
   Besides the springboot security 2.x which is new, all the other parts of this project were relatively easy.  The only other part that was a little complex was the Project.java JOINFORMULA to calculate the winning bid. 
   
How did I feel about the project?
    Point: 9 
    I was excited to use springboot.  I had used springboot 1.x but not 2.x so it gave me an opportunity to exercise what I already knew and learn more about the new 2.x features.
    
How did I feel about the coding exercise in the interview process?
    Point: 10
    
I love the opportunity to exercise my coding skills.

What would I change about the process or exercise?
   Not much.
   

