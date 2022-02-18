module com.spacecodee.microsoft_teams_redesign {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spacecodee.microsoft_teams_redesign to javafx.fxml;
    exports com.spacecodee.microsoft_teams_redesign;
    exports com.spacecodee.microsoft_teams_redesign.controller.dashboard;
    opens com.spacecodee.microsoft_teams_redesign.controller.dashboard to javafx.fxml;
}