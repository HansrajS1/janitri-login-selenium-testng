# Janitri Login Automation (Selenium + TestNG)

This project automates the login functionality test for the Janitri Dashboard using **Java**, **Selenium WebDriver**, and **TestNG**.

## Features
- Tests login functionality with valid and invalid credentials.
- Validates "Invalid Credentials" message for wrong inputs.
- Checks login button behavior when fields are empty.
- Page Object Model (POM) implementation for cleaner code.
- Uses Maven for dependency management.

## Tech Stack
- **Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Build Tool:** Maven


## Running Tests
1. Install Java (>= 11) and Maven.
2. Clone this repository:
   ```bash
   git clone https://github.com/HansrajS1/janitri-login-selenium-testng.git
   cd janitri-login-selenium-testng
   mvn test
