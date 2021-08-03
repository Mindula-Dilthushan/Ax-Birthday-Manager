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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFormController {

    public AnchorPane anchorLordPane;
    public JFXButton btnNew;
    public Label lblDate,lblTime;
    public JFXButton btnView;
    public JFXButton btnExit;

    //Property Injection
    Util util = new Util();

    public void initialize(){
        try {
            util.setAnchor(anchorLordPane, "NewForm.fxml");
        }catch (Exception e){
        }
        generateDate();
    }

    public void btnNewOnAction(ActionEvent actionEvent) throws Exception {
        try {
            util.setAnchor(anchorLordPane, "NewForm.fxml");
        }catch (Exception e){
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

    public void btnViewOnAction(ActionEvent actionEvent) {
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
    }
}
