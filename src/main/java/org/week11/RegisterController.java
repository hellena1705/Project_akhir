package org.week11;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class RegisterController {

    @FXML private TextField fullNameField;
    @FXML private TextField emailIdField;
    @FXML private PasswordField passwordField;
    @FXML private Button submitButton;

    @FXML
    public void register(ActionEvent event) throws SQLException, IOException {
        Window owner = submitButton.getScene().getWindow();

        // Validasi input kosong
        if (fullNameField.getText().isEmpty() || emailIdField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Semua field harus diisi.", false);
            return;
        }

        // Ambil input
        String fullName = fullNameField.getText();
        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        // Simpan ke DB
        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(fullName, emailId, password);

        // Tampilkan konfirmasi dan tunggu user klik OK
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registrasi Berhasil!", "Selamat datang, " + fullName, true);

        // Setelah klik OK, pindah ke login
        try {
            Apps.setRoot("Login-view", "Login", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Alert yang bisa pilih show() atau showAndWait()
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message, boolean wait) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        if (owner != null) {
            alert.initOwner(owner);
        }

        if (wait) {
            alert.showAndWait();
        } else {
            alert.show();
        }
    }
}
