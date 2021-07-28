//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import util.Util;

public class MainFormController {

    public AnchorPane anchorLordPane;
    public JFXButton btnNew;

    //Property Injection
    Util util = new Util();

    public void btnNewOnAction(ActionEvent actionEvent) throws Exception {
        try {
            util.setAnchor(anchorLordPane, "NewForm.fxml");
        }catch (Exception e){
        }
    }
}
