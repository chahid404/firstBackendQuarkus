package pfe.formation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import pfe.formation.data.Product;
import pfe.formation.data.Provider;
import pfe.formation.repository.ProductRepository;
import pfe.formation.repository.ProviderRepository;

import javax.inject.Inject;
//import javax.json.bind.annotation.JsonbTransient;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.print.Pageable;
import java.sql.SQLException;
import java.util.List;


@Path("/products")
public class ProductResource {

    @Inject
    ProductRepository productRepository;
    @Inject
    ProviderRepository providerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> hello() throws SQLException {
        return productRepository.findAll().list();
    }


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product productById(@PathParam("id") Integer id) {
        return productRepository.findById(id);
    }


    @Path("/{provider_id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Product AddNewProduct(@PathParam("provider_id") Integer provider_id, Product p) {

        Product newp = new Product();

        if (providerRepository.findById(provider_id) == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        newp.setDesignation(p.getDesignation());
        newp.setPrice(p.getPrice());
        newp.setQuantite(p.getQuantite());
        newp.setProvider(providerRepository.findById(provider_id));
        productRepository.persist(newp);
        return newp;
    }


    @Path("/{id}/provider/{p_id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Product updateProduct(@PathParam("id") Integer id, @PathParam("p_id") Integer provider_id, Product p) {
        if (productRepository.findById(id) == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Product newp = productRepository.findById(id);
        newp.setProvider(providerRepository.findById(provider_id));
        newp.setDesignation(p.getDesignation());
        newp.setPrice(p.getPrice());
        newp.setQuantite(p.getQuantite());
        return newp;
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Product> DeleteProduct(@PathParam("id") Integer id) {
        productRepository.delete(productRepository.findById(id));
        return productRepository.findAll().list();
    }

    @Path("/search/{mot}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductByDesignation(@PathParam("mot") String mot) {
        return productRepository.list("designation LIKE ?1", mot);
    }
}