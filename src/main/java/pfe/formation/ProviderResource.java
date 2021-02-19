package pfe.formation;


import pfe.formation.data.Provider;
import pfe.formation.repository.ProviderRepository;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/providers")
public class ProviderResource {


    @Inject
    ProviderRepository providerRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Provider> getAllProviders(){
        return providerRepository.findAll().list();
    }




    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Provider providerById(@PathParam("id") Integer id){
        return providerRepository.findById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Provider AddNewProvider (Provider p){
        providerRepository.persistAndFlush(p);
        return p;
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Provider updateProvider(@PathParam("id") Integer id ,Provider p){
        Provider newp = providerRepository.findById(id);
        if (newp == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        newp.setEmail(p.getEmail());
        newp.setName(p.getName());
        return providerRepository.findById(id);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Provider> DeleteProvider(@PathParam("id") Integer id){
        providerRepository.delete(providerRepository.findById(id));
        return providerRepository.findAll().list();
    }

}
