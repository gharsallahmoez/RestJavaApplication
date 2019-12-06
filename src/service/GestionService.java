package service;

import java.util.List;

import javax.jws.WebService;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	@Produces(MediaType.TEXT_PLAIN)
	public String getBookById(@PathParam("id") int id) {
	//	List<Livre> Lis = g.getAllLivre();
	// ***	Livre l = g.getLivre(id);
	//	System.out.println(l.getDescription());
	//	Lis.add(l);
		return "helloooo";
	}
	@GET
	@Path("/allbooks")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Livre> getAll() {
		
		List<Livre> l = g.getAllLivre();
		return l;
	}
}
