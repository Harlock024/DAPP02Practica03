package org.uv.dapp02practica03;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author harlock024
 */
@Entity
@Table(name = "empleados")
public class EmpleadoPojo implements Serializable{
    @Id
    @Column
    @GeneratedValue(generator = "empleados_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "empleados_id_seq",
            sequenceName = "empleados_id_seq",initialValue = 1,allocationSize = 1)
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
