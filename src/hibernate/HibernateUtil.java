//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package hibernate;

import entity.UserBirthday;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry sReg=new StandardServiceRegistryBuilder()
                .loadProperties("resource/application.properties")
                .build();

        Metadata mData=new MetadataSources(sReg)
                .addAnnotatedClass(UserBirthday.class)
                .getMetadataBuilder().build();
        return mData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
