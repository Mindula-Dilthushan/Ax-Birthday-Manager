//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Util {

    public void setAnchor(AnchorPane anchorPane, String Location) throws Exception{
        anchorPane.getChildren().clear();
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/" + Location));
        anchorPane.getChildren().addAll(load.getChildren());
    }
}
