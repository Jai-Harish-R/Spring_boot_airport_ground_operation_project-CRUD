# Flight Ground Operation CRUD Project
This project is a microservices-based system built with Spring Boot to manage various aspects of flight ground operations. It includes multiple interconnected services for handling different operations at an airport.
## Architecture Overview
The system is designed using a microservices architecture, with independent services handling distinct domains of airport and flight operations. A central API Gateway is used to route and manage incoming requests to the appropriate microservices.
### Microservices
1. **Spring Gateway API**
   - Serves as the central entry point for the system.
   - Routes API requests to the respective backend microservices.
2. **Flight Project**
   - Manages core flight information and operations.
   - Runs on port: `8089` (default).
3. **Baggage System Project**
   - Handles luggage tracking, processing, and management.
4. **Crew Project**
   - Manages airline crew members, scheduling, and assignments.
5. **Fuel Project**
   - Responsible for managing flight fuel requirements and refuelling operations.
6. **Gate Project**
   - Manages airport gate assignments and schedules for arriving and departing flights.
7. **Operations Project**
   - Handles general ground operations and coordination tasks.
## Technologies Used
- **Java 17**
- **Spring Boot 3.x**
- **Spring Cloud Gateway** (for API Gateway)
- **Spring Data JPA**
- **Databases:** MySQL and H2 Database (in-memory, primarily for testing)
- **Lombok** for boilerplate code reduction
- **Maven** for dependency management and building
## Prerequisites
- JDK 17 installed
- Maven installed
- MySQL Server (if using for production/local testing databases)
## Getting Started
1. Clone or download the repository.
2. Build the entire project or individual services using Maven:
   ```bash
   mvn clean install
   ```
3. Run the microservices independently. Ensure that the **Spring Gateway API** is running to route requests to the other services.
   ```bash
   mvn spring-boot:run
   ```
## Development
Each microservice is an independent Maven project. You can open each subdirectory in your preferred IDE (like IntelliJ IDEA or Eclipse) to work on them individually. They each have their own `pom.xml`, `application.properties`/`application.yml`, and source code directories.

## Output :
