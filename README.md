# RBAC Authentication System - Spring Boot

## Project Overview
This project implements Role-Based Access Control (RBAC) authentication using Spring Boot and JWT.

Users can register, login, and access protected APIs based on their roles.

## Features
- User Registration
- Login Authentication
- JWT Token Generation
- Role-Based Authorization
- Secure REST APIs
- Spring Security Integration

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT
- Maven
- H2 Database

## API Endpoints

### Register User
POST /api/auth/register

### Login
POST /api/auth/login

Response:
{
"token":"JWT_TOKEN"
}

### Admin Dashboard
GET /api/admin/dashboard

Header:
Authorization: Bearer TOKEN

Response:
Admin Dashboard Accessed

## How to Run

1. Clone repository
2. Run project:

mvn spring-boot:run

3. Test APIs using Postman or Thunder Client
