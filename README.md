# Employee Management System with Spring Boot


## Overview

This project is a comprehensive Employee Management System (EMS) built using Spring Boot, Java 17, and Maven. It covers basic CRUD (Create, Read, Update, Delete) operations and serves as an excellent resource for those looking to grasp the fundamentals of backend development with Spring Boot. The project is structured as a Maven project, making it easy to understand and extend.

## Key Features

- **CRUD Operations:** Create, Read, Update, and Delete employee records.
- **Spring Boot:** Leverage the power of the Spring Boot framework for efficient and scalable backend development.
- **Java 17:** Stay up-to-date with the latest Java features and enhancements.
- **Maven Project:** Well-organized and easily manageable project structure with Maven.

## Table of Contents

- [How to Use](#how-to-use)
  - [Setup Project](#setup-project)
  - [Check the Code](#check-the-code)
  - [Dependencies](#dependencies)
  - [Annotations](#annotations)
- [Contributing](#contributing)
- [License](#license)

## How to Use

### Setup Project

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your-username/employee-management-system.git
    ```

2. **Set up Development Environment:**

    Ensure you have Java 17 and Maven installed on your machine. If not, download and install them from the official websites.

3. **Run the Application:**

    ```bash
    cd employeems
    mvn spring-boot:run
    ```

    The application will be accessible at `http://localhost:8080`.

### Check the Code

Use Postman or any API testing tool to interact with the API endpoints. Here are the available endpoints:

- **saveEmployee:**
  - Method: POST
  - URL: `http://localhost:8080/api/v1/employee/saveEmployee`
  - Body: JSON payload with employee details.

- **getAllEmployees:**
  - Method: GET
  - URL: `http://localhost:8080/api/v1/employee/getAllEmployees`

- **searchEmployee:**
  - Method: GET
  - URL: `http://localhost:8080/api/v1/employee/searchEmployee/{empId}`
  - Body: JSON payload with updated employee details.

- **deleteEmployee:**
  - Method: DELETE
  - URL: `http://localhost:8080/api/v1/employee/deleteEmployee/{empId}`

- **updateEmployee:**
  - Method: PUT
  - URL: `http://localhost:8080/api/v1/employee/updateEmployee`

### Dependencies

```xml
<!-- Add the following dependencies to your pom.xml file -->

<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Database Connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- ModelMapper -->
    <dependency>
        <groupId>org.modelmapper</groupId>
        <artifactId>modelmapper</artifactId>
        <version>2.4.4</version>
    </dependency>
</dependencies>
```
### Annotations

- **@GetMapping:**
  - Used to map HTTP GET requests to specific methods.
  - Example:
    ```java
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        // Implementation
    }
    ```

- **@PostMapping:**
  - Used to map HTTP POST requests to specific methods.
  - Example:
    ```java
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        // Implementation
    }
    ```

- **@DeleteMapping:**
  - Used to map HTTP DELETE requests to specific methods.
  - Example:
    ```java
    @DeleteMapping("/api/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
    // Implementation
    }
    ```

    - **@Autowired:**
  - Marks a constructor, field, or setter method to be autowired by Spring's dependency injection facilities.
  - Example:
    ```java
    @Autowired
    private EmployeeService employeeService;
    ```

    - **@RestController:**
  - A specialized version of the @Controller annotation that is a stereotype for the controller implementation.
  - Example:
    ```java
    @RestController
    @RequestMapping("/api/employees")
    public class EmployeeController {
        // Implementation
    }
    ```

    - **@PutMapping:**
  - Used to map HTTP PUT requests to specific methods.
  - Example:
    ```java
    @PutMapping("/api/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        // Implementation
    }
    ```

    - **@RequestMapping:**
  - Maps HTTP requests to handler methods.
  - Example:
    ```java
    @RequestMapping("/api/employees")
    public class EmployeeController {
        // Implementation
    }
    ```

    - **@RequestBody:**
  - Used to bind the HTTP request body to a method parameter.
  - Example:
    ```java
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        // Implementation
    }
    ```

    - **@PathVariable:**
  - Used to extract values from the URI path.
  - Example:
    ```java
    @GetMapping("/api/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        // Implementation
    }
    ```

    - **@AllArgsConstructor:**
  - Generates a constructor with one parameter for each field in the class.
  - Example:
    ```java
    @AllArgsConstructor
    public class Employee {
        // Implementation
    }
    ```

    - **@NoArgsConstructor:**
  - Generates a default constructor with no parameters.
  - Example:
    ```java
    @NoArgsConstructor
    public class Employee {
        // Implementation
    }
    ```

    - **@Data:**
  - Lombok annotation to generate getters, setters, toString, and other utility methods.
  - Example:
    ```java
    @Data
    public class Employee {
        // Implementation
    }
    ```

    - **@Entity:**
  - JPA annotation to indicate that the class is an entity.
  - Example:
    ```java
    @Entity
    public class Employee {
        // Implementation
    }
    ```

    - **@GeneratedValue:**
  - Specifies the strategy to generate values for the annotated field.
  - Example:
    ```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ```

    - **@Table:**
  - Specifies the primary table for the annotated entity.
  - Example:
    ```java
    @Entity
    @Table(name = "employees")
    public class Employee {
        // Implementation
    }
    ```

    - **@Service:**
  - Indicates that a class is a service class.
  - Example:
    ```java
    @Service
    public class EmployeeService {
        // Implementation
    }
    ```

    - **@Transactional:**
  - Defines the scope of a single database transaction.
  - Example:
    ```java
    @Service
    @Transactional
    public class EmployeeService {
        // Implementation
    }
    ```

  ## Contributing

    Feel free to contribute to the project by opening issues or creating pull requests.

  ## License

    This project is licensed under the [MIT License](LICENSE).

    
