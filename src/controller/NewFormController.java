//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.3
package controller;

import bo.BOFactory;
import bo.custom.UserBirthdayBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.UserBirthdayDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class NewFormController {

    public JFXTextField txtFullName;
    public JFXButton btnSave;
    public JFXDatePicker datePicker;
    public Label getDate;
    public TextField txtId;

    private UserBirthdayBO userBirthdayBO = (UserBirthdayBO) BOFactory.getBoFactory().getSuperBO(
            BOFactory.BOType.UserBirthday
    );

    public void btnSaveOnAction(ActionEvent actionEvent) {

        LocalDate localDate = datePicker.getValue();
        getDate.setText(getDate(localDate.toString()));
        try {
            boolean isSaved = userBirthdayBO.saveBirthday(
                    new UserBirthdayDTO(
                            txtId.getText(),
                            txtFullName.getText(),
                            getDate.getText()

                    )
            );
        } catch (Exception e) {
        }
    }

    public String getDate(String Date) {
        SimpleDateFormat simpleDateFormat = null;
        java.util.Date date = null;
        try {
            simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            date = simpleDateFormat.parse(Date);
            simpleDateFormat.applyPattern("EEEE d MMM yyyy");
        } catch (Exception e) {
        }
        return simpleDateFormat.format(date);
    }
}
