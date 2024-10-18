# 🌟 Spring-MVC-JPA

This project showcases the powerful integration of **Spring MVC** with **Java Persistence API (JPA)**, utilizing **Hibernate** for efficient Object-Relational Mapping (ORM). 

### 🌟 Key Features:
- **Seamless Backend Integration**: Effortlessly manage and query data with a robust backend framework.
  
- **Core Entities**: 
  - **Instructor**: Manage instructor details and associated courses.
  - **Address**: Handle address information for instructors and courses.
  - **Course**: Organize and maintain course offerings and their related entities.

- **Database Schema Management**: Leverage **Liquibase** to manage database versioning and migrations, ensuring smooth transitions during updates.

- **API Testing**: Utilize **Postman** as a client for testing API endpoints, making it easy to verify and validate the functionality of your application.

With this setup, you can efficiently build and maintain a robust application tailored to your data management needs!


## 📝 Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Technologies](#technologies)
- [Demo](#demo)
- [Docker](#docker)
- [Resources](#resources)

## 🚀 Features

This project boasts a range of powerful features that streamline your application development and enhance user experience:

### 🌟 Key Functionalities

- **CRUD Operations**: Effortlessly perform *Create, Read, Update, and Delete* operations for Instructor, Address, and Course entities.
  
- **MVC Architecture**: Utilize a clean and organized *Model-View-Controller* architecture for clear separation of concerns.

- **Spring Boot Integration**: Benefit from *Spring Boot* for rapid backend development with automatic configuration and dependency management.

- **Efficient ORM**: Leverage *JPA & Hibernate* for smooth Object-Relational Mapping and database interactions.

- **Dynamic Web Pages**: Render interactive and dynamic web pages with *Thymeleaf*.

- **Database Management**: Manage database schema versioning and migrations seamlessly with *Liquibase*.

- **API Testing Made Easy**: Use *Postman* for quick and efficient testing of your API endpoints.

---

### 🌈 Explore the Features

#### 1. **Create**
- Easily add new Instructor, Address, or Course entities through a user-friendly web form.

#### 2. **Read**
- Retrieve and display data for Instructor, Address, or Course entities in a well-structured format.

#### 3. **Update**
- Modify existing entities with an intuitive interface for effortless changes.

#### 4. **Delete**
- Remove entities with a single click, simplifying data management.

---

With these features, your application will be robust, user-friendly, and maintainable!

Remove entities with a single click.

---

## 📖 Prerequisites

Before you begin, ensure you have the following:

- *Java Development Kit (JDK)* installed (preferably JDK 11 or later).
- *Maven* installed for dependency management.
- Your favorite IDE (e.g., IntelliJ IDEA, Eclipse) for code editing.
- *Postman* for API testing.

---

## ✨ Getting Started

Follow these steps to set up your Spring Boot project quickly and efficiently:

### 🚀 Step 1: Create a Spring Boot Project

Begin by generating a new Spring Boot project using [Spring Initializr](https://start.spring.io/) with the following settings:

- **Project**: Maven Project
- **Language**: Java
- **Spring Boot**: Latest stable version
- **Packaging**: Jar
- **Dependencies**: 
  - Spring Web
  - Spring Data JPA
  - Thymeleaf
  - Liquibase
  - MySQL Driver

Click **"Generate"** to download the project zip file.

---

### 📥 Step 2: Extract and Import into IDE

1. Extract the downloaded zip file.
2. Import the project into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

---

### ⚙️ Step 3: Configure Database and Liquibase

- **Database Configuration**: Update your `application.properties` or `application.yml` file with your database connection details.
  
- **Liquibase Configuration**: Configure Liquibase in your `application.properties` and add your changelog files in `src/main/resources/db/changelog`.
   ```application.properties
   spring.liquibase.change-log=db/changelog/db_master_changelog.xml
   ```

- **Environment Variables**: Store sensitive data (like database passwords) in environment variables instead of hardcoding them in your `application.properties` file. For example:
  ```application.properties
  database.url=jdbc:mysql://localhost:3307/mydb
  database.username=root
  database.password=shosh404@@

  spring.datasource.url=${database.url}
  spring.datasource.username=${database.username}
  spring.datasource.password=${database.password}
  ```

---

### 🏗️ Step 4: Define Entities

Create entity classes for **Instructor**, **Address**, and **Course** in your project.

---

### 📚 Step 5: Create Repository Interfaces

Define repository interfaces for each entity to enable CRUD operations.

---

### 🔄 Step 6: Implement Service Layer

Develop a service layer to manage business logic and facilitate interaction with repositories.

---

### 🖥️ Step 7: Implement Controllers

Create MVC controllers to manage HTTP requests and return appropriate views.

---

### 🎨 Step 8: Create Thymeleaf Views

Design Thymeleaf templates for displaying forms and results.

---

### 🧪 Step 9: Test Using Postman

Utilize Postman to test your API endpoints by sending requests to create, read, update, and delete entities.

---

### ▶️ Step 10: Run Your Application

Run your Spring Boot application. The server will start at [http://localhost:8082](http://localhost:8082).

---

## 🎥 Demo

[Watch the demo video here](https://drive.google.com/drive/folders/1cQkyXQUHpSO7XV-EUS8uM8-wmAYQZUMe)

---

## 🐳 Docker

To push your Docker image to Docker Hub, use the following command:

```bash
docker push your-docker-repo/spring-mvc-app:latest
```
## 🗂 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot) - Official documentation for Spring Boot.
- [Spring MVC Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc) - Comprehensive guide to Spring MVC framework.
- [JPA and Hibernate Guide](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/) - Detailed documentation for using JPA with Hibernate.
- [Liquibase Documentation](https://www.liquibase.org/documentation/index.html) - Resources for managing database schema with Liquibase.
- [Postman Documentation](https://learning.postman.com/) - Official documentation for using Postman to test APIs.
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html) - Guide to using Thymeleaf for server-side rendering.
- [Docker Documentation](https://docs.docker.com/get-started/) - Getting started with Docker for containerization.

