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
    SessionFactory sf = HibernateUtil.getSessionFactory();
        Session  session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        EmpleadoPojo pojo = new EmpleadoPojo();
        long id =2;
        pojo.setId(id);
        pojo.setName("gonzalo");
        pojo.setAddress("telas poncho");
        pojo.setPhone("1234213123");
        
        System.out.println(  pojo.getName()); 
        
        session.save(pojo);
     
    }
}
