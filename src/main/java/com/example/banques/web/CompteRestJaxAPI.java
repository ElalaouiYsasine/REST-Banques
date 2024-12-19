package com.example.banques.web;


import com.example.banques.entities.Compte;
import com.example.banques.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Path("/banque")


//qui implémente un service web
public class CompteRestJaxAPI {
    @Autowired

    private CompteRepository compteRepository ;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML })
    public List<Compte> compteList() {
        Iterable<Compte> comptesIterable = compteRepository.findAll();
        List<Compte> comptesList = new ArrayList<>();
        comptesIterable.forEach(comptesList::add);
        return comptesList;
    }

    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam("id") Long id) {
        Optional<Compte> optionalCompte = compteRepository.findById(id);
       //valeur potentiellement absente
        if (optionalCompte.isPresent()) {
            return optionalCompte.get();
        } else {
            throw new NotFoundException("Compte with ID " + id + " not found");
        }
    }

    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){

        return  compteRepository.save(compte);
    }

    //mettre à jour
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte ,@PathParam("id") Long id){
        compte.setId(id);
        return  compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id){

        compteRepository.deleteById(id);
    }

}
