
# JavaFX Application Setup with Laragon and VS Code/Eclipse

This project demonstrates a simple JavaFX application with user registration and login functionality, designed using **JavaFX** and **Scene Builder**. The frontend is built with FXML and controls like **TextField**, **Button**, and more, and the backend handles user interactions like registering and logging in, with **Laragon** used as the recommended environment for MySQL.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
  - [Setting up in Visual Studio Code](#setting-up-in-visual-studio-code)
  - [Setting up in Eclipse](#setting-up-in-eclipse)
- [Running the Application](#running-the-application)
- [Database Setup with Laragon](#database-setup-with-laragon)
- [Contributing](#contributing)
- [License](#license)

---

## Prerequisites

Before you begin, ensure you have the following installed:
- **Java Development Kit (JDK) 11 or later**: [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://jdk.java.net/)
- **JavaFX SDK**: [Download JavaFX SDK](https://gluonhq.com/products/javafx/)
- **Scene Builder**: [Gluon Scene Builder](https://gluonhq.com/products/scene-builder/)
- **Laragon**: [Laragon Download](https://laragon.org/download/), which provides an easy-to-use development environment with MySQL.
- **IDE**:
  - [Visual Studio Code](https://code.visualstudio.com/) with the [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
  - OR [Eclipse IDE](https://www.eclipse.org/downloads/)

---

## Installation

### Setting up in Visual Studio Code

1. **Install the JDK**:
   - Download and install JDK 11 or higher from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://jdk.java.net/).
   
2. **Install the Java Extension Pack**:
   - Open VS Code.
   - Go to the Extensions tab (`Ctrl + Shift + X`), search for **Java Extension Pack**, and install it.
   
3. **Configure the JDK Path**:
   - If the JDK isn't automatically detected, configure it manually:
     - Open **Settings** (`Ctrl + ,`).
     - Search for `java.configuration.runtimes` and configure the path to your JDK installation like this:
       ```json
       "java.configuration.runtimes": [
         {
           "name": "JavaSE-11",
           "path": "C:/Program Files/Java/jdk-11",
           "default": true
         }
       ]
       ```

4. **Install JavaFX SDK**:
   - Download the **JavaFX SDK** from [JavaFX SDK](https://gluonhq.com/products/javafx/).
   - Extract it and set it up in your project.

5. **Install Scene Builder**:
   - Download and install **Scene Builder** from [Gluon Scene Builder](https://gluonhq.com/products/scene-builder/).
   - In VS Code, you can link **FXML** files to open with Scene Builder.

### Setting up in Eclipse

1. **Install Eclipse**:
   - Download and install **Eclipse IDE for Java Developers** from [Eclipse Download](https://www.eclipse.org/downloads/).
   
2. **Install the JDK**:
   - Download and install **JDK 11 or above** from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

3. **Set up JDK in Eclipse**:
   - Open Eclipse.
   - Navigate to **Window > Preferences > Java > Installed JREs**.
   - Add your installed JDK path (e.g., `C:/Program Files/Java/jdk-11`).

4. **Install JavaFX Plugin from Eclipse Marketplace**:
   - Open Eclipse.
   - Go to **Help > Eclipse Marketplace**.
   - Search for **e(fx)clipse** in the marketplace and install it. This plugin provides tooling support for JavaFX, including FXML support.
   - Restart Eclipse after installation.

5. **Set up JavaFX SDK**:
   - Download and install the **JavaFX SDK** from [JavaFX SDK](https://gluonhq.com/products/javafx/).
   - Add the JavaFX `.jar` files in the **Build Path**:
     - Right-click on your project > **Build Path** > **Configure Build Path** > **Add External JARs** > Select all `.jar` files in the `lib` folder of the JavaFX SDK.

6. **Install Scene Builder**:
   - Download **Scene Builder** from [Scene Builder](https://gluonhq.com/products/scene-builder/) to design your **FXML** files visually.
   - Set it up in Eclipse to open `.fxml` files automatically.

---

## Running the Application

### Visual Studio Code
1. Ensure that your **JavaFX SDK** is properly configured in your project.
2. Open the project in VS Code.
3. Run your JavaFX application by executing:
   ```bash
   java --module-path <path_to_javafx_sdk> --add-modules javafx.controls,javafx.fxml -jar <your_jar_file>.jar
   ```

### Eclipse
1. Open the project in Eclipse.
2. Right-click your **Main Class** (e.g., `MON.java`) and select **Run As > Java Application**.

---

## Database Setup with Laragon

This project uses **Laragon** as the recommended development environment for MySQL. Follow these steps to set it up:

1. **Download and Install Laragon**:
   - Download **Laragon** from the [official website](https://laragon.org/download/).
   - Install it and start the environment.

2. **Create MySQL Database**:
   - Launch **MySQL** via **Laragon**. You can manage databases using **phpMyAdmin**.
   - Create a new database for your project:
     ```sql
     CREATE DATABASE account;
     USE account;
     CREATE TABLE user (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(50) NOT NULL,
         password VARCHAR(50) NOT NULL
     );
     ```

3. **Database Connection in Code**:
   - In your JavaFX project, ensure that the database connection class (`MON_database.java`) connects to MySQL using `JDBC`. Example connection code:
     ```java
     public class MON_database {
         public static Connection connectDB() {
             try {
                 String url = "jdbc:mysql://localhost:3306/account";
                 String user = "root";
                 String password = "";
                 Connection connection = DriverManager.getConnection(url, user, password);
                 return connection;
             } catch (SQLException e) {
                 e.printStackTrace();
                 return null;
             }
         }
     }
     ```

4. **MySQL Workbench (Optional)**:
   - If you prefer, you can use **MySQL Workbench** to manage your database, but Laragon’s built-in phpMyAdmin is more lightweight for quick testing.

---

## Contributing

If you'd like to contribute to this project, feel free to submit a pull request or open an issue.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
