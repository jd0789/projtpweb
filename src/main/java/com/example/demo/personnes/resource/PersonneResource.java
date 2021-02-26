package com.example.demo.personnes.resource;

import com.example.demo.livres.bdd.Livre;
import com.example.demo.personnes.process.Personne;
import com.example.demo.personnes.process.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("personnes")
public class PersonneResource {
	@Autowired
	private PersonneRepository personneRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// POST /personnes
	public Personne createPersonne(Personne p) {
		return personneRepository.save(p);
	}


	@GET
	@Path("{id}/livres")
	@Produces(MediaType.APPLICATION_JSON)
	// GET /personnes/{id}/livres
	public List<Livre> listerLivres(@PathParam("id") Long id) {
		return personneRepository.findById(id).get().getLivres();
	}

}
