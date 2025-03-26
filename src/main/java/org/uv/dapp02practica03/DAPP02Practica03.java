/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp02practica03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author harlock024
 */
public class DAPP02Practica03 {

    public static void main(String[] args) {
//    SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session  session = sf.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        
        EmpleadoPojo pojo = new EmpleadoPojo();
        EmpleadoDAO dao = new EmpleadoDAO();
    
   
        pojo.setName("hadith024");
        pojo.setAddress("col");
        pojo.setPhone("1234213123");
        
        dao.create(pojo);
        
//        System.out.println(pojo.getName()); 
//        
//        session.save(pojo);
//        transaction.commit();
        System.out.println("empleado guardado");
     
    }
}
