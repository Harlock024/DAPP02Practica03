package org.uv.dapp02practica03;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author harlock024
 */
public class EmpleadoDAO implements IDAOGeneral<EmpleadoPojo, Long> {

    @Override
    public EmpleadoPojo create(EmpleadoPojo pojo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(pojo);
        transaction.commit();
        return pojo;
    }

    @Override
    public EmpleadoPojo update(EmpleadoPojo pojo, Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            EmpleadoPojo empleadoToEdit = session.get(EmpleadoPojo.class, id);
            if (empleadoToEdit != null) {
                empleadoToEdit.setName(pojo.getName());
                empleadoToEdit.setAddress(pojo.getAddress());
                empleadoToEdit.setPhone(pojo.getPhone());

                session.update(empleadoToEdit);
                transaction.commit();
                return pojo;
            }else{
                transaction.commit();
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pojo;
    }
    @Override
    public boolean delete(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        EmpleadoPojo pojo = session.get(EmpleadoPojo.class, id);
        if (pojo != null) {
            session.delete(pojo);
            transaction.commit();
            return true;
        }
        transaction.commit();

        return false;
    }

    @Override
    public EmpleadoPojo fetch_by_id(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        EmpleadoPojo empleado = new EmpleadoPojo();
        try {
            empleado = session.get(EmpleadoPojo.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }

    @Override
    public List<EmpleadoPojo> fetch_all() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<EmpleadoPojo> empleados = new ArrayList<>();
        try {
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<EmpleadoPojo> criteriaQuery = criteriaBuilder.createQuery(EmpleadoPojo.class);
//            Root<EmpleadoPojo> root = criteriaQuery.from(EmpleadoPojo.class);
//            criteriaQuery.select(root);
//           empleados = session.createQuery(criteriaQuery).getResultList();
            empleados = session.createQuery("From EmpleadoPojo", EmpleadoPojo.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
