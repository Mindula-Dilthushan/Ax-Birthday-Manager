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

import java.util.ArrayList;
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
    public boolean deleteBirthday(String id) throws Exception {
       return userBirthdayDAO.delete(id);
    }

    @Override
    public List<UserBirthdayDTO> getAllBirthday() throws Exception {
        List<UserBirthday> all = userBirthdayDAO.getAll();
        ArrayList<UserBirthdayDTO> userBirthdayDTOArrayList = new ArrayList<>();
        for (UserBirthday userBirthday : all) {
            userBirthdayDTOArrayList.add(
                    new UserBirthdayDTO(
                            userBirthday.getId(),
                            userBirthday.getFullname(),
                            userBirthday.getBirthdaydate())
            );
        }
        return userBirthdayDTOArrayList;
    }

    @Override
    public UserBirthdayDTO searchBirthday(UserBirthdayDTO userBirthdayDTO) throws Exception {
        return null;
    }

    @Override
    public String getUserCountID() throws Exception {
        String lastID = userBirthdayDAO.getUserCount();
        if (lastID == null) {
            return "B001";
        } else {
            int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;
            if (newID < 10) {
                return "B00" + newID;
            } else if (newID < 100) {
                return "B0" + newID;
            } else {
                return "B" + newID;
            }
        }
    }
}
