package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.*;


@Path("/Auction")
@Stateless
public class RestService {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAuctions() {
		TypedQuery<Auction> query = em.createNamedQuery(Auction.FIND_ALL, Auction.class);
		Auctions auctions = new Auctions(query.getResultList());
		return Response.ok(auctions).build();
	}

	@GET
	@Path("{id}")
	public Response getAuction(@PathParam("id") String id) {
		int idInt = Integer.parseInt(id);
		Auction auction = em.find(Auction.class, idInt);
		if (auction == null)
			throw new NotFoundException();
		return Response.ok(auction).build();
	}
}