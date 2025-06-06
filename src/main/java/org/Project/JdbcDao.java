package org.Project;

import java.sql.*;

public class JdbcDao {

    private final String jdbcURL = "jdbc:sqlite:database.db"; // Sesuaikan jika pakai MySQL/PostgreSQL
    private final String jdbcUsername = "";
    private final String jdbcPassword = "";

    // Membuat koneksi ke database
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL);
    }

    // Simpan data registrasi
    public void insertRecord(String fullName, String email, String password) {
        String sql = "INSERT INTO users(full_name, email, password) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Validasi login
    public boolean validateLogin(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
