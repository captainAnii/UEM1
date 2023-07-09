# University Event Management

-This README file provides a comprehensive guide and documentation for the University Event Management API project. The API is built using the Spring Boot framework and incorporates various components such as models, controllers, services, and repositories. The project also utilizes Lombok, Data JPA, validation, and H2 database dependencies.

## Dependencies

- Dev tools
- Lombok
- Data JPA
- Validation
- H2 Database

## Project Structure

- com.example.eventmanagement
- com.example.eventmanagement.model
- com.example.eventmanagement.controller
- com.example.eventmanagement.service
- com.example.eventmanagement.repository
- com.example.eventmanagement.exception
- com.example.eventmanagement.dto

## API Endpoints

### Student Endpoints

- GET /students
- GET /students/{id}
- POST /students
- PUT /students/{id}
- DELETE /students/{id}

### Event Endpoints

- GET /events
- GET /events/{id}
- GET /events/date/{date}
- POST /events
- DELETE /events/date/{date}
- PUT /events/date/{date}

## Usage

1. Clone or download the repository.
2. Set up the required dependencies.
3. Configure the database connection properties.
4. Build and run the application.
5. Access the API endpoint

## Contributing
- Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to create a pull request or submit an issue.

## License
- This project is licensed under the MIT License.
