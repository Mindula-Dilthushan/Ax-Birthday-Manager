//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package bo.custom;

import bo.SuperBO;
import dto.UserBirthdayDTO;
import entity.UserBirthday;

import java.util.List;

public interface UserBirthdayBO extends SuperBO {

    boolean saveBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception;
    boolean updateBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception;
    boolean deleteBirthday(String id) throws Exception;
    List<UserBirthdayDTO> getAllBirthday() throws Exception;
    UserBirthdayDTO searchBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception;
    String getUserCountID()throws Exception;
}
