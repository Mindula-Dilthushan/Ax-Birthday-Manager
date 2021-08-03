//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package dao.custom;

import dao.CrudDAO;
import entity.UserBirthday;

public interface UserBirthdayDAO extends CrudDAO<UserBirthday,String> {
    String getUserCount()throws Exception;
}
