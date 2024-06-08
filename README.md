# SalonLink-Java Application
This was a class project for my Software Architecture and Design class at SMU that I am continuing to explore and build upon.

Currently, this SalonLink application simplifies the discovery, selection, and booking of salon services, allowing users to browse nearby salons, pick services, and make bookings using a user-friendly interface. 

I am in the process of:

1. Getting the application to also allow salon owners to effectively manage the information about their salon.​
2. Improving both the front-end and back-end parts of the application through additional features, etc. to improve its functionality and usability.
   
## Client-Server Architecture
 This application is based on a Client-Server architecture. The Code was developed in Java with spring boot Initialization in the IntellIJ IDEA 2023.3.2 IDE version 17.

### JDK and IntellIJ Installation:

-Visit the official Oracle to download the JDK for the appropriate Operating System.

-Visit the official IntelliJ IDEA download page at JetBrains and download the Community or Ultimate version of the platform according to the Operating system.

-Download the PostgreSql and create a database called "SalonLink" . The default port number is 5432.


### Application setup and configuration

-Download the Project as a whole from the repository.

-Upon Successful installation of the platform, navigate to the startup screen, select Open, and load the project as a maven project from the folder where you downloaded it to.

-Run the project

-Upon Successful compilation, Navigate to Chrome -> http://localhost:8080/registration

### Application Execution

-Give the User Details on the registration page -> Register with required details on the input form.

-click on the link below it that redirects to the login page -> Email and password

-On the dashboard page click the "search for service button" and type a service you are interested in such as 'manicure' or 'haircut'

-From the list of salons sorted by distance given back, click on "salon services" for a particular salon to see its services. This will take you to another page where you can see all the services offered by that particular salon listed.

-On the same page, select from a dropdown of list of the services offered by that particular salon and then click on the "make reservation" button next to it to make a reservation.
