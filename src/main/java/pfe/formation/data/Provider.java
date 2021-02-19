package pfe.formation.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;


@Entity
public class Provider extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String email;
    public String name;
    //@OneToMany(targetEntity=Product.class)
    //public List<Product> products;

    public Provider() {
    }

    public Provider(Integer id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    //public List<Product> getProducts() {
       // return products;
   // }

    //public void setProducts(List<Product> products) {
       // this.products = products;
   // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
