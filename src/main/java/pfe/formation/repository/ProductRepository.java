package pfe.formation.repository;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import pfe.formation.data.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.awt.print.Pageable;
import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<Product,Integer> {


}
