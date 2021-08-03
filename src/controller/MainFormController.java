//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.3
package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MainFormController {

    public AnchorPane anchorLordPane;
    public JFXButton btnNew, btnExit, btnView;
    public Label lblDate, lblTime;

    //Property Injection
    Util util = new Util();

    public void initialize() {
        try {
            util.setAnchor(anchorLordPane, "NewForm.fxml");
        } catch (Exception e) {
        }
        generateDate();
    }

    public void btnNewOnAction(ActionEvent actionEvent) throws Exception {
        try {
            util.setAnchor(anchorLordPane, "NewForm.fxml");
        } catch (Exception e) {
        }
    }

    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            util.setAnchor(anchorLordPane, "ViewForm.fxml");
        } catch (Exception e) {
        }
    }

    private void generateDate() {
        lblDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void btnExitOnAction(ActionEvent actionEvent) {
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == ok) {
            Stage exit_stage = (Stage) btnExit.getScene().getWindow();
            exit_stage.close();
        } else {
        }
    }
}
