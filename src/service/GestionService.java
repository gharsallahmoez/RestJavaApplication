package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.spi.resource.Singleton;

import metier.GestionImpl;
import metier.entites.Livre;
@Path("/service")
@Singleton
@Produces(MediaType.APPLICATION_JSON)

public class GestionService {
	GestionImpl g ;
	public GestionService() {
		g = new GestionImpl();	
	}
	@GET
	@Path("/bookById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre getBookById(@PathParam("id") int id) {
		//List<Livre> Lis = new ArrayList<Livre>();
		Livre l = g.getLivre(id);
		//Lis.add(l);
		return l;
	}
	@GET
	@Path("/allbooks")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Livre> getAll() {
		
		List<Livre> l = g.getAllLivre();
		return l;
	}
	
	@POST
	@Path("/book")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addLivre(Livre l) {
		
		g.addLivre(l);
		 String result = "Record entered: "+ l.getId();
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/book/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response updateLivre(@PathParam("id") int id ,Livre l) {
	//	Livre l = g.getLivre(id);
		l.setId(id);
		g.updateLivre(l);
		 String result = "Record entered: "+ l.getId();
		return Response.status(201).entity(result).build();
	}
	@DELETE
	@Path("/book/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response deleteLivre(@PathParam("id") int id) {
	Livre l = g.getLivre(id);
	
		g.deleteLivre(l);
		 String result = "Record entered: "+ l.getId();
		return Response.status(201).entity(result).build();
	}
}
