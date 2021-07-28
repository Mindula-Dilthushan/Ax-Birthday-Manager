//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package dao;

import dao.custom.impl.UserBirthdayDAOImpl;

public class DAOFactory {

    public enum DAOType{
        UserBirthday
    }
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory !=null) ? daoFactory : (daoFactory = new DAOFactory());
    }

    public SuperDAO getSuperDAO(DAOType daoType){
        switch (daoType){
            case UserBirthday:
                return new UserBirthdayDAOImpl();
            default:
                return null;
        }
    }
}
