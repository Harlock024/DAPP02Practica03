package org.uv.dapp02practica03;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author harlock024
 */
@Entity
@Table(name = "empleados")
public class EmpleadoPojo implements Serializable{
    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;


    
    

    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

}
