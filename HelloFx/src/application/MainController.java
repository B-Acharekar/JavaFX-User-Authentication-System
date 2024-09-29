package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {

    @FXML
    private TextField create_Pass;

    @FXML
    private TextField create_name;

    @FXML
    private TextField login_pass;

    @FXML
    private TextField login_username;
    
    @FXML
    private Button loginpage_button;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;

    // Registration method
 // Registration method
    public void regBtn() {
        if (create_name.getText().isEmpty() || create_Pass.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Error Message", "Please fill all blank fields");
            return;
        }
        
        if (create_Pass.getText().length() < 8) {
            showAlert(AlertType.ERROR, "Error Message", "Password must be at least 8 characters long");
            return;
        }
        
        String regData = "INSERT INTO users (username, password) VALUES (?, ?)";
        connect = MainDatabase.connectDB();

        try {
            // Check if username already exists
            String checkUsername = "SELECT username FROM users WHERE username = ?";
            prepare = connect.prepareStatement(checkUsername);
            prepare.setString(1, create_name.getText());
            result = prepare.executeQuery();

            if (result.next()) {
                showAlert(AlertType.ERROR, "Error Message", create_name.getText() + " is already taken");
            } else {
                prepare = connect.prepareStatement(regData);
                prepare.setString(1, create_name.getText());
                prepare.setString(2, create_Pass.getText());
                prepare.executeUpdate();
                showAlert(AlertType.INFORMATION, "Information Message", "Successfully registered!");
                clearFields();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Login method
    public void loginBtn() {
        if (login_username.getText().isEmpty() || login_pass.getText().isEmpty()) {
            showAlert(AlertType.ERROR, "Error Message", "Please enter both Username and Password");
            return;
        }

        String selectData = "SELECT username, password FROM users WHERE username = ? AND password = ?";
        connect = MainDatabase.connectDB();

        try {
            prepare = connect.prepareStatement(selectData);
            prepare.setString(1, login_username.getText());
            prepare.setString(2, login_pass.getText());

            result = prepare.executeQuery();

            if (result.next()) {
                UserData.setUsername(login_username.getText());
                showAlert(AlertType.INFORMATION, "Information Message", "Successfully Logged In!");
                loadDashboard();
                loginpage_button.getScene().getWindow().hide();
            } else {
                showAlert(AlertType.ERROR, "Error Message", "Incorrect Username or Password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility to show alert
    private void showAlert(AlertType type, String title, String content) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Clear registration fields after successful registration
    private void clearFields() {
        create_name.setText("");
        create_Pass.setText("");
    }

    // Load dashboard after successful login
    private void loadDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}