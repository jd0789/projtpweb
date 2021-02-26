package com.example.demo.livres.resource;

import com.example.demo.livres.bdd.Livre;
import com.example.demo.livres.bdd.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("livres")
public class LivreResource {
    @Autowired
    private LivreRepository livreRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livre> listerLivres() {
        List<Livre> livres = new ArrayList<>();
        livreRepository.findAll().forEach(livres::add);
        return livres;
    }
}
