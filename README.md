# Spring-MVC-JPA

This project demonstrates the use of Spring MVC along with Java Persistence API (JPA) for database operations and Hibernate for Object-Relational Mapping (ORM). It provides a seamless backend integration for managing and querying data, featuring three main entities: Instructor, Address, and Course. Liquibase is used for database schema management, and Postman is utilized as a client for testing the API.

## 📝 Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Technologies](#technologies)
- [Demo](#demo)
- [Docker](#docker)
- [Resources](#resources)

## 🚀 Features

- *Create, Read, Update, and Delete* operations for Instructor, Address, and Course entities.
- *MVC architecture* for clear separation of concerns.
- *Spring Boot* for backend development with automatic configuration and dependency management.
- *JPA & Hibernate* for efficient ORM and database interactions.
- *Thymeleaf* for rendering dynamic web pages.
- *Liquibase* for database versioning and migrations.
- *Postman* for testing API endpoints.

Explore the powerful features of this project:

### 1. *Create*

Add new Instructor, Address, or Course entities through a user-friendly web form.

### 2. *Read*

Retrieve and display data for Instructor, Address, or Course entities in a structured format.

### 3. *Update*

Modify existing entities with an intuitive interface.

### 4. *Delete*

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

### Step 1: Create a Spring Boot Project

Generate a new Spring Boot project using [Spring Initializr](https://start.spring.io/) with the following settings:

- Project: Maven Project
- Language: Java
- Spring Boot: Latest stable version
- Packaging: Jar
- Dependencies: Spring Web, Spring Data JPA, Thymeleaf, Liquibase, MySQL Driver

Click "Generate" to download the project zip file.

### Step 2: Extract and Import into IDE

Extract the downloaded zip file and import the project into your preferred IDE.

### Step 3: Configure Database and Liquibase

- *Database Configuration*: Update `application.properties` or `application.yml` with your database connection details.
- *Liquibase Configuration*: Configure Liquibase in your `application.properties` and add your changelog files in `src/main/resources/db/changelog`.

### Step 4: Define Entities

Create entity classes for Instructor, Address, and Course in your project.

### Step 5: Create Repository Interfaces

Create repository interfaces for each entity to perform CRUD operations.

### Step 6: Implement Service Layer

Implement a service layer to handle business logic and interact with repositories.

### Step 7: Implement Controllers

Create MVC controllers to handle HTTP requests and return appropriate views.

### Step 8: Create Thymeleaf Views

Develop Thymeleaf templates for displaying forms and results.

### Step 9: Test Using Postman

Use Postman to test your API endpoints by sending requests to create, read, update, and delete entities.

### Step 10: Run Your Application

Run your Spring Boot application. The server will start at `http://localhost:8080`.

---

## 📚 Technologies

- *Spring Boot*: For building the backend application.
- *Spring MVC*: For handling web requests and rendering views.
- *JPA & Hibernate*: For ORM and database interactions.
- *Thymeleaf*: For server-side templating.
- *Liquibase*: For database schema management and migrations.
- *MySQL*: As the database.
- *Postman*: For API testing.

---

## 🎥 Demo

[Watch the demo video here] (vedio not perpared)([https://github.com/your-repo/demo-link](https://github.com/Mohamad-shosha/Spring-Jpa-Mvc/blob/main/shosha20241004%20020452626.mp4)).

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

