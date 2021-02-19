package pfe.formation;


import pfe.formation.data.Store;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

//@Path("/stores")
public class StoreResource {

/*
    @Inject
    StoreRepository storeRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Transactional(Transactional.TxType.NEVER)
    public List<Store> getAllStores() throws SQLException {
        return storeRepository.findAll().list();
    }


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Store storeById(@PathParam("id") Integer id){
        return storeRepository.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Store AddNewStore (Store p){
        storeRepository.persistAndFlush(p);
        return p;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Store updateStore(@PathParam("id") Integer id ,Store p){
        Store newp = storeRepository.findById(id);
        if (newp == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        newp.setEmail(p.getEmail());
        newp.setStoreName(p.getStoreName());
        newp.setPhone(p.getPhone());
        newp.setStreet(p.getStreet());
        newp.setCity(p.getCity());
        newp.setState(p.getState());
        newp.setZipCode(p.getZipCode());
        return storeRepository.findById(id);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Store> DeleteStore(@PathParam("id") Integer id){
        storeRepository.delete(storeRepository.findById(id));
        return storeRepository.findAll().list();
    }*/
}
