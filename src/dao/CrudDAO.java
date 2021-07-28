//Alpha X Software Company
//Mindula Dilthushan
//Ax Birthday Manager
//v1.0.0
package dao;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {

    boolean save(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(T entity) throws Exception;
    List<T> getAll() throws Exception;
    T search(T entity) throws Exception;
}
