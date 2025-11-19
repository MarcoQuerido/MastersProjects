# EDOM Project, Part 3 Industry Cases (JHipster)

Model-Driven Engineering

– Principles
* For instance, how they address "models+transformations=software"?

Min 1:22 - 3:33 = initial configurations through inputs generate folders and code inside the project folder.   

– Integrating MDSE in the Development Process
* How does the case relate to Domain-Driven Design?

Min 11:18 - 12:31
A domain problem is addressed in the project (Admins can see User's data). An if condition is used to restrict admins from seeing user data (only the current user can see that user's data).

* How does the case relates to Tests oriented approaches (e.g., Test-Driven Development)?

Min 12:32 - 13:36
A User is assigned to the blog, otherwise it will not appear in the tests.


– Domain-Specific Languages
* Are there DSLs in the case? How can we characterize the DSLs?

Min 4:13 - 5:30 = JDL (JHipster Domain Language), interface allows to design entities manually, create fake data and later download.

– Tools used
* What MDE tools are used in the case? How they relate to the ones in the
EDOM course?

It uses the JHipster user interface to create entities which can be later used to describe the application.
Compared to the tools used during the course, it is way quicker and more reliable (JHipster can create entities in a couple minutes with fake data).
If a user wants to manually input data, it can be done with a couple code configurations (Min 6:09 - 7:31). 

- Constraints

Min 7:32 - 9:39
With some minor JHipster code configurations, it is possible to "simulate" ocl constraints addressed in the classes. In the video example, the users and admins can view the same blog posts. A constraint (findByUserIsCurrentUser method) is applied so that they only view their corresponding posts. Manual input, not automatic.

Min 11:18 - 12:31 (DDD approach as well)
A domain problem is addressed in the project (Admins can see User's data). An if condition is used to restrict admins from seeing user data (only the current user can see that user's data). Manual input, not automatic

- Transformations

Min 9:40 - 11:17
With some minor JHipster code configurations, it is possible to "simulate" atl transformations addressed in the classes. In the video example, it is expected that html tags applied in the interface convert to html code in the whole project (switch post.content with innerHTML). Manual input, not automatic.
