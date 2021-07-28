//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package bo;

import bo.custom.impl.UserBirthdayBOImpl;

public class BOFactory {

    public enum BOType{
        UserBirthday
    }

    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        return (boFactory != null) ? boFactory:(boFactory=new BOFactory());
    }

    public SuperBO getSuperBO(BOType boType){
        switch (boType){
            case UserBirthday:
                return new UserBirthdayBOImpl();
            default:
                return null;
        }
    }
}
