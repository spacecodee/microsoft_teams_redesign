package com.spacecodee.microsoft_teams_redesign.utils;

import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Images {
    private static final String URL_MAIN_OPTION1 = "src/main/resources/com/spacecodee/microsoft_teams_redesign/assets";
    private static final String URL_MAIN_OPTION2 = "target/classes/com/spacecodee/microsoft_teams_redesign/assets/";

    public static void addIcon(String icon, ImageView imageView) {
        try {
            File fileImgBack = new File(URL_MAIN_OPTION2 + icon);
            Image imgBack = new Image(fileImgBack.toURI().toString());
            imageView.setImage(imgBack);
        } catch (Exception ex) {
            System.out.println("I'm Sorry, an current error, not image\n");
            ex.printStackTrace(System.out);
        }
    }

    public static void addIcon(String url, Label label) {
        File fileImgBack = new File(Images.URL_MAIN_OPTION2 + url);
        Image imgBack = new Image(fileImgBack.toURI().toString());
        ImageView view = new ImageView(imgBack);
        view.setFitWidth(400);
        view.setPreserveRatio(true);
        label.setGraphic(view);
    }

    public static void borderRadiusImgProfile(ImageView imageView) {
        Rectangle clip = new Rectangle(
                imageView.getFitWidth(), imageView.getFitHeight()
        );
        clip.setArcWidth(150);
        clip.setArcHeight(150);
        imageView.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageView.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        imageView.setClip(null);

        // store the rounded image in the imageView.
        imageView.setImage(image);
    }

    public static void borderRadiusImgProfile(ImageView imageView, int radius) {
        Rectangle clip = new Rectangle(
                imageView.getFitWidth(), imageView.getFitHeight()
        );
        clip.setArcWidth(radius);
        clip.setArcHeight(radius);
        imageView.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageView.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        imageView.setClip(null);

        // store the rounded image in the imageView.
        imageView.setImage(image);
    }
}
