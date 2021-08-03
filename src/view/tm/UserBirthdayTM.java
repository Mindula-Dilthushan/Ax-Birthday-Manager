package view.tm;

import com.jfoenix.controls.JFXButton;
import dto.UserBirthdayDTO;
import entity.UserBirthday;

public class UserBirthdayTM {

    private String id;
    private String fname;
    private String birth;
    private JFXButton btn;

    public UserBirthdayTM() {
    }

    public UserBirthdayTM(String id, String fname, String birth, JFXButton btn) {
        this.id = id;
        this.fname = fname;
        this.birth = birth;
        this.btn = btn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "UserBirthdayTM{" +
                "id='" + id + '\'' +
                ", fname='" + fname + '\'' +
                ", birth='" + birth + '\'' +
                ", btn=" + btn +
                '}';
    }
}
