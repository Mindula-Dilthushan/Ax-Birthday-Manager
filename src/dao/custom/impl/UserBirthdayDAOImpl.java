//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package dao.custom.impl;

import dao.custom.UserBirthdayDAO;
import entity.UserBirthday;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.Serializable;
import java.util.List;

public class UserBirthdayDAOImpl implements UserBirthdayDAO {

    private SessionFactory sessionFactory;

    public UserBirthdayDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean save(UserBirthday entity) throws Exception {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(entity);
        session.getTransaction().commit();
        return save !=null;
    }

    @Override
    public boolean update(UserBirthday entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(UserBirthday entity) throws Exception {
        return false;
    }

    @Override
    public List<UserBirthday> getAll() throws Exception {
        return null;
    }

    @Override
    public UserBirthday search(UserBirthday entity) throws Exception {
        return null;
    }

    @Override
    public String getUserCount() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select ID from userbirthday order by ID desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();
        session.close();
        return id;


    }
}
