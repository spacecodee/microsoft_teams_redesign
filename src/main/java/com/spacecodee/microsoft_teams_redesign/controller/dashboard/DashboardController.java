package com.spacecodee.microsoft_teams_redesign.controller.dashboard;

import com.spacecodee.microsoft_teams_redesign.utils.Images;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private BorderPane appContainer;


    @FXML
    private ImageView imgUser1;

    @FXML
    private ImageView imgUser2;

    @FXML
    private ImageView imgUser3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addRadiusImages();
    }

    private void addRadiusImages() {
        var urlImages = new String[]{
                "img/man1.png", "img/man2.png", "img/man3.png"
        };

        var listImages = new ArrayList<ImageView>() {
            {
                add(DashboardController.this.imgUser1);
                add(DashboardController.this.imgUser2);
                add(DashboardController.this.imgUser3);
            }
        };

        for (int i = 0; i < listImages.size(); i++) {
            Images.addIcon(urlImages[i], listImages.get(i));
            Images.borderRadiusImgProfile(listImages.get(i), 500);
        }
    }
}