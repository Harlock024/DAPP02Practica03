/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.dapp02practica03;

import java.util.List;

/**
 *
 * @author harlock024
 */

public interface IDAOGeneral<T, ID> {

    public T create(T pojo);
    
    public T update(T pojo, ID id);
    
    public boolean delete(ID id);
   
    public T fetch_by_id(ID id);
    
    public List<T> fetch_all();
    
}
