# FirstWebApp
A full stack web application for e-learning portal. Front end - JSP pages, Backend - Java, Database - MySQL.

Functional Requirements:

1. There are two roles: admin and user.
2. The user can:
   a. Login with his secure credentials
   b. Provide Feedback
   c. See all his previously provided feedback
   d. Fill contact form
   e. See contact form filling hisotry
   f. View all courses
   g. Enroll the courses from the courses list
   h. Check what courses, he is currently enrolled in
   
3. The admin can:
  a. Login with his credentials
  b. View all courses
  c. View all user details
  d. Add new courses 
  e. View the enrollments details : which user is enrolled in what all courses
  
Non Functional Requirements:
a. Security has been added for login
b. Once the user is logged out, pressing the back button on the browser, won't reopen the page. Caching has been disabled 

Steps to run the project:
1. Create a database Eg: sampleDB on MySQL.
2. Run the MySQL scripts.txt file on Workbench.
3. Open the DBUtil files in the project and change the database nam and port number there, as per your configuration.
4. Start running the project from Login.jsp. TomCat Server is required to run it

