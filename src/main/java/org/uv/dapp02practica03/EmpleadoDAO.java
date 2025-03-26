    package org.uv.dapp02practica03;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;

    /**
     *
     * @author harlock024
     */
    public class EmpleadoDAO implements IDAOGeneral<EmpleadoPojo, Integer> {

        @Override
        public EmpleadoPojo create(EmpleadoPojo pojo) {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session  session = sf.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(pojo);
            transaction.commit();
            return pojo;
        }
        @Override
        public EmpleadoPojo update(EmpleadoPojo pojo, Integer id) {
                 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        }
        @Override
        public boolean delete(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public EmpleadoPojo fetch_by_id(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public List<EmpleadoPojo> fetch_all() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
