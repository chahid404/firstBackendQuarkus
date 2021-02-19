package pfe.formation.data;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Stock  {


    public Store store;
    public Product product;
    public Integer quantity;

}
