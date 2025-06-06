package org.Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Apps extends Application {

    public static void openViewWithModal(String s, boolean b) {
        // Masih kosong, isi jika dibutuhkan
    }

    public static void showAndWait() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Registrasi-view.fxml"));
        primaryStage.setTitle("Form Registrasi");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void setRoot(String fxml, String title, boolean resize) throws IOException {
        FXMLLoader loader = new FXMLLoader(Apps.class.getResource(fxml + ".fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(resize);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
