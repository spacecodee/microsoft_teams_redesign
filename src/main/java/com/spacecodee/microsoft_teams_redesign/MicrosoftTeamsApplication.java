package com.spacecodee.microsoft_teams_redesign;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MicrosoftTeamsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MicrosoftTeamsApplication.class.getResource("view/dashboard/dashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setMinHeight(600);
        stage.setMinWidth(500);
        stage.setTitle("Microsoft Teams Redesign - By Spacecodee");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}