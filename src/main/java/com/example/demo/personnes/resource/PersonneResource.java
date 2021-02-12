package com.example.demo.personnes.resource;

import com.example.demo.personnes.process.Personne;
import com.example.demo.personnes.process.PersonneBDD;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("personnes")
public class PersonneResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> lister(@QueryParam("prenom") String prenom, @QueryParam("age") Integer age) {
		if (age == null && prenom == null) {
			return PersonneBDD.getAllPersonne();
		} else if (age != null && prenom != null) {
			return PersonneBDD.filter(prenom, age);
		} else {
			throw new BadRequestException("Il faut renseigner les 2 filtres");
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	// GET /personnes/{id}
	public Personne detailler(@PathParam("id") int id) {
		return PersonneBDD.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// POST /personnes
	public void ajouter(Personne p) {
		PersonneBDD.addPersonne(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	// DELETE /personnes/{id}
	public void supprimer(@PathParam("id") int id) {
		PersonneBDD.remove(id);
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	// PATCH /personnes/{id}
	public void updateAge(@PathParam("id") int id, Personne p) {
		PersonneBDD.updateAge(id, p.getAge());
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	// PUT /personnes/{id}
	public void replace(@PathParam("id") int id, Personne p) {
		PersonneBDD.replace(id, p);
	}

}
