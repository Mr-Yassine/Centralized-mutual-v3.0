package com.example.mutuelle_centralisee_v2;

import com.example.mutuelle_centralisee_v2.DataBase.MailSender;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;

public class MutualApp extends Application {


    private static Stage stg;



    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MutualApp.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mutual Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException, MessagingException {
        FXMLLoader fxmlLoader = new FXMLLoader(MutualApp.class.getResource(fxml));
        stg.setScene(new Scene(fxmlLoader.load()));
    }



    public static void main(String[] args) {
        launch();
    }
}