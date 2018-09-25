/*
package rest;

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






@Path("/user")
@Stateless
public class RestService {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_XML)

	public Response getUser() {
		TypedQuery<User> query = em.createNamedQuery(User.FIND_ALL, User.class);
		User user = new user(query.getResultList());
		return Response.ok(user).build();
	}
}
/*
	@GET
	@Path("{id}")
	public Response getTweet(@PathParam("id") String id) {
		int idInt = Integer.parseInt(id);
		Tweet tweet = em.find(Tweet.class, idInt);
		if (tweet == null)
			throw new NotFoundException();
		return Response.ok(tweet).build();
	}
}
*/