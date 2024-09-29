
# JavaFX User Authentication System

## Description
This project is a simple user authentication system built using JavaFX. It allows users to create an account and log in using their credentials. The application connects to a MySQL database to store user information securely.

## Features
- User Registration: Users can create an account by entering a username and a password.
- User Login: Users can log in with their credentials.
- Input Validation: The application checks for empty fields and enforces password length requirements.
- Alerts: User-friendly alerts inform the user of registration and login success or errors.

## Requirements
- Java Development Kit (JDK) 8 or higher
- MySQL Database
- JavaFX library
- MySQL Connector/J (JDBC Driver)

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Set Up Your Own Database:**
   - Create a MySQL database of your choice (you can name it anything, e.g., `my_database`).
   - Create a table `users` with the following structure:
     ```sql
     CREATE TABLE users (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(255) NOT NULL UNIQUE,
         password VARCHAR(255) NOT NULL
     );
     ```

3. **Configure Database Connection:**
   - Modify the database connection parameters in `MainDatabase.java` to match your database settings:
     ```java
     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
     ```

4. **Run the Application:**
   - Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).
   - Run the `Main` class to start the application.

## Note
This project is for educational purposes only. It is not intended for production use. Always ensure to use secure practices when handling user credentials and personal data in real applications.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
