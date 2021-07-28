//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBirthday {

    @Id
    private String id;
    private String fullname;
    private String birthdaydate;

    public UserBirthday() {
    }

    public UserBirthday(String id, String fullname, String birthdaydate) {
        this.id = id;
        this.fullname = fullname;
        this.birthdaydate = birthdaydate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdaydate() {
        return birthdaydate;
    }

    public void setBirthdaydate(String birthdaydate) {
        this.birthdaydate = birthdaydate;
    }

    @Override
    public String toString() {
        return "UserBirthday{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthdaydate='" + birthdaydate + '\'' +
                '}';
    }
}
