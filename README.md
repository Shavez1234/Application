This project is a Ticket Booking Application built using Java, Spring Boot, and MySQL for managing ticket bookings, including customer details and journey information.

Key Features:
Ticket Booking CRUD Operations: The application allows for the creation, retrieval, updating, and deletion (CRUD) of booking records. Each booking record includes:
Customer ID (Unique Identifier)
Customer Name
Journey Details (Source, Destination, Date, Time)


Spring Boot Framework: Utilizes Spring Boot to develop a robust and scalable backend, ensuring efficient handling of booking data.
MySQL Database: The application stores booking information in a MySQL database, providing a secure and reliable way to manage records.
REST APIs: Developed RESTful APIs using Spring Boot to handle various requests, including adding new bookings, retrieving booking data, updating records, and deleting entries.
Ticket Issuance: After successful data acquisition, the system issues a ticket with booking details back to the customer.
Validation and Error Handling: Ensures valid input through form validation and handles errors gracefully, providing meaningful responses to invalid operations.
MVC Architecture: The project follows the Model-View-Controller architecture to ensure separation of concerns and maintainable code.


Tools & Technologies:
Java
Spring Boot
MySQL Database
JPA/Hibernate for database interactions
Postman for API testing
Maven for project management


How to Run:
Clone the repository from GitHub.
Set up MySQL and configure the database connection in application.properties.
Build the project using Maven.
Run the Spring Boot application.
