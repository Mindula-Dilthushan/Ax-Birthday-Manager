//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package bo.custom.impl;

import bo.custom.UserBirthdayBO;
import dao.DAOFactory;
import dao.custom.UserBirthdayDAO;
import dto.UserBirthdayDTO;
import entity.UserBirthday;
import java.util.List;

public class UserBirthdayBOImpl implements UserBirthdayBO {

    private UserBirthdayDAO userBirthdayDAO;

    public UserBirthdayBOImpl() {
        userBirthdayDAO = (UserBirthdayDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOFactory.DAOType.UserBirthday);
    }

    @Override
    public boolean saveBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception {
        return userBirthdayDAO.save(
                new UserBirthday(
                        userBirthdayDTO.getId(),
                        userBirthdayDTO.getFullname(),
                        userBirthdayDTO.getBirthdaydate()
                )
        );
    }

    @Override
    public boolean updateBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception {
        return false;
    }

    @Override
    public List<UserBirthdayDTO> getAllBirthday() throws Exception {
        return null;
    }

    @Override
    public UserBirthdayDTO searchBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception {
        return null;
    }
}
