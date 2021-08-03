//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.1.0
package controller;

import bo.BOFactory;
import bo.custom.UserBirthdayBO;
import com.jfoenix.controls.JFXButton;
import dto.UserBirthdayDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.UserBirthdayTM;
import java.util.List;
import java.util.Optional;

public class ViewFormController {

    public TableView <UserBirthdayTM>tblVIew;
    public TableColumn colId,colFullName,colBirth,colOption;

    private UserBirthdayBO userBirthdayBO = (UserBirthdayBO) BOFactory.getBoFactory().getSuperBO(
            BOFactory.BOType.UserBirthday
    );

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("fname"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllUsers();
    }

    public void loadAllUsers(){
        try {
            ObservableList<UserBirthdayTM> userBirthdayTMObservableList;
            userBirthdayTMObservableList = FXCollections.observableArrayList();
            List<UserBirthdayDTO> list = userBirthdayBO.getAllBirthday();
            for (UserBirthdayDTO userBirthdayDTO : list) {
                JFXButton btn = new JFXButton("Delete");
                UserBirthdayTM tm = new UserBirthdayTM(
                        userBirthdayDTO.getId(),
                        userBirthdayDTO.getFullname(),
                        userBirthdayDTO.getBirthdaydate(),
                        btn);
                userBirthdayTMObservableList.add(tm);
                btn.setOnAction((e) -> {
                    try {
                        ButtonType ok = new ButtonType("OK",
                                ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("NO",
                                ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Are You Sure ?", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            System.out.println(tm.getId());
                            if (userBirthdayBO.deleteBirthday(tm.getId())) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
                                loadAllUsers();
                                return;
                            }
                            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
                        } else {
                        }

                    } catch (Exception e1) {
                    }

                });
            }
            tblVIew.setItems(userBirthdayTMObservableList);
        } catch (Exception e) {
        }
    }
}
