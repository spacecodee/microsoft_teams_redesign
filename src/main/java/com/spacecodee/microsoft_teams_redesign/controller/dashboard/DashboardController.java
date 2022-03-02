package com.spacecodee.microsoft_teams_redesign.controller.dashboard;

import com.spacecodee.microsoft_teams_redesign.controller.components.dashboard.CardNotificationsView;
import com.spacecodee.microsoft_teams_redesign.controller.components.dashboard.SideBarController;
import com.spacecodee.microsoft_teams_redesign.controller.components.dashboard.TopHeaderController;
import com.spacecodee.microsoft_teams_redesign.utils.AppUtils;
import com.spacecodee.microsoft_teams_redesign.utils.Images;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
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

    @FXML
    private VBox notificationContainer;

    private static final String URL_SIDE_BAR = AppUtils.URL_COMPONENTS + "dashboard/side-bar-view.fxml";
    private static final String URL_TOP_HEADER = AppUtils.URL_COMPONENTS + "dashboard/top-header-view.fxml";
    private static final String URL_CARD_NOTIFICATION = AppUtils.URL_COMPONENTS + "dashboard/card-notifications-view.fxml";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addRadiusImages();
        this.addSideBarApp();
        this.addTopHeaderApp();
        this.addCardsNotifications();
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

    private void addSideBarApp() {
        var fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource(DashboardController.URL_SIDE_BAR));
        try {
            VBox sideBar = fxmlLoader.load();
            SideBarController sideBarController = fxmlLoader.getController();

            this.appContainer.setLeft(sideBar);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    private void addTopHeaderApp() {
        var fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getResource(DashboardController.URL_TOP_HEADER));
        try {
            HBox sideBar = fxmlLoader.load();
            TopHeaderController sideBarController = fxmlLoader.getController();

            this.appContainer.setTop(sideBar);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }

    private void addCardsNotifications() {
        FXMLLoader[] fxmlLoader = new FXMLLoader[4];

        for (int i = 0; i < fxmlLoader.length; i++) {
            fxmlLoader[i] = new FXMLLoader();
            fxmlLoader[i].setLocation(this.getClass().getResource(DashboardController.URL_CARD_NOTIFICATION));

            try {
                HBox sideBar = fxmlLoader[i].load();
                CardNotificationsView sideBarController = fxmlLoader[i].getController();

                this.notificationContainer.getChildren().add(sideBar);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

    }
}